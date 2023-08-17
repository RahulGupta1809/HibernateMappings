package com.cglia.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cglia.hibernate.bean.StudentAddressBean;
import com.cglia.hibernate.bean.StudentBean;
import com.cglia.hibernate.bean.StudentResultBean;
import com.cglia.hibernate.repository.StudentAddressRepository;
import com.cglia.hibernate.repository.StudentRepository;
import com.cglia.hibernate.repository.StudentResultRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final StudentAddressRepository studentAddressRepository;
	private final StudentResultRepository studentResultRepository;

	public StudentService(StudentRepository studentRepository, StudentAddressRepository studentAddressRepository,
			StudentResultRepository studentResultRepository) {
		this.studentRepository = studentRepository;
		this.studentAddressRepository = studentAddressRepository;
		this.studentResultRepository = studentResultRepository;
	}

	@Transactional
	public void saveStudentDetails(StudentBean student) {
		if (student == null || student.getResult() == null || isAnyFieldNull(student)) {
			throw new IllegalArgumentException("Invalid student details");
		}

		// Check if the result ID already exists
		StudentResultBean existingResult = studentResultRepository.findById(student.getResult().getResultId())
				.orElse(null);
		if (existingResult != null) {
			throw new IllegalArgumentException("Result ID already exists");
		}

		List<StudentAddressBean> addresses = student.getAddresses();

		for (StudentAddressBean address : addresses) {
			address.setStudent(student);
			studentAddressRepository.save(address);
		}

		studentRepository.save(student);
	}

	private boolean isAnyFieldNull(StudentBean student) {
		return student.getName() == null || student.getGender() == null || student.getEmail() == null
				|| student.getProjects() == null || student.getAddresses() == null || student.getAddresses().isEmpty();
	}

	public List<StudentBean> getAllStudentDetails() {
		List<StudentBean> students = studentRepository.findAll();
		return students;
	}

	public StudentBean getStudentdetail(Long studentId) {

		StudentBean student = studentRepository.findById(studentId).get();
		return student;
	}

	public void deleteStudentRecord(Long studentId) {
		StudentBean student = studentRepository.findById(studentId).orElse(null);

		if (student != null) {
			// Delete the related records in the child tables first
			student.getProjects().clear(); // Remove all projects associated with the student

			// Then delete the student record
			studentRepository.delete(student);
		}
	}

}