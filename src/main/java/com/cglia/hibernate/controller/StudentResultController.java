package com.cglia.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.bean.StudentResultBean;
import com.cglia.hibernate.service.StudentResultService;

@RestController
@RequestMapping("/student")
public class StudentResultController {

	private final StudentResultService studentResultService;

	@Autowired
	public StudentResultController(StudentResultService studentResultService) {
		this.studentResultService = studentResultService;
	}

	@GetMapping("/result/pass")
	public List<StudentResultBean> passResult() {

		return studentResultService.getResultsWithTotalGreaterThan100();
	}

	@GetMapping("/result/fail")
	public List<StudentResultBean> failResult() {

		return studentResultService.getResultsWithTotalLessThan100();
	}

}