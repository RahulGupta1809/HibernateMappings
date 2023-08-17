package com.cglia.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.hibernate.bean.StudentBean;
import com.cglia.hibernate.bean.StudentProjectBean;
import com.cglia.hibernate.repository.StudentProjectRepository;

@Service
public class StudentProjectService {

	private final StudentProjectRepository studentProjectRepository;

	@Autowired
	public StudentProjectService(StudentProjectRepository studentProjectRepository) {
		this.studentProjectRepository = studentProjectRepository;
	}

	public List<StudentBean> getStudentsByProjectId(int projectId) {
		Optional<StudentProjectBean> project = studentProjectRepository.findById(projectId);
		if (project.isPresent()) {
			return project.get().getStudents();
		} else {
			return null;
		}
	}
}
