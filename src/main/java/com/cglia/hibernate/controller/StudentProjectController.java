package com.cglia.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.bean.StudentBean;
import com.cglia.hibernate.service.StudentProjectService;



@RestController
@RequestMapping("/student")
public class StudentProjectController {

	private final StudentProjectService studentProjectService;

	@Autowired
	public StudentProjectController(StudentProjectService studentProjectService) {
		this.studentProjectService = studentProjectService;
	}

	@GetMapping("/project/{projectId}")
	public ResponseEntity<List<StudentBean>> getStudentsByProjectId(@PathVariable int projectId) {
		List<StudentBean> students = studentProjectService.getStudentsByProjectId(projectId);
		if (students != null) {
			return ResponseEntity.ok(students);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}