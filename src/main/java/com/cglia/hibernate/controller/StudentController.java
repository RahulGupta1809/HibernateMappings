package com.cglia.hibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.bean.StudentBean;
import com.cglia.hibernate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger =
            LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStudentDetails(@RequestBody StudentBean student) {
        logger.info("Received request to save student details");

        try {
            logger.debug("Student data received: {}", student);
            studentService.saveStudentDetails(student);
            logger.info("Student saved successfully");
            return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error while saving student details", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view/all")
    public List<StudentBean> viewAllStudentDetails() {
        logger.info("Received request to fetch all student details");

        List<StudentBean> students = studentService.getAllStudentDetails();
        logger.debug("Total students found: {}", students.size());

        return students;
    }

    @GetMapping("/view/{studentId}")
    public StudentBean viewStudentdetail(@PathVariable Long studentId) {
        logger.info("Received request to fetch student with ID: {}", studentId);

        StudentBean student = studentService.getStudentdetail(studentId);
        logger.debug("Student details: {}", student);

        return student;
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> removeStudent(@PathVariable Long studentId) {
        logger.info("Received request to delete student with ID: {}", studentId);

        try {
            studentService.deleteStudentRecord(studentId);
            logger.info("Student deleted successfully with ID: {}", studentId);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error while deleting student with ID: {}", studentId, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
