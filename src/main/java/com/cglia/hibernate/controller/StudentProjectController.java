package com.cglia.hibernate.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger =
            LoggerFactory.getLogger(StudentProjectController.class);

    private final StudentProjectService studentProjectService;

    @Autowired
    public StudentProjectController(StudentProjectService studentProjectService) {
        this.studentProjectService = studentProjectService;
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<StudentBean>> getStudentsByProjectId(@PathVariable int projectId) {

        logger.info("Received request to fetch students for projectId: {}", projectId);

        List<StudentBean> students = studentProjectService.getStudentsByProjectId(projectId);

        if (students != null && !students.isEmpty()) {
            logger.info("Found {} students for projectId: {}", students.size(), projectId);
            logger.debug("Student list: {}", students);
            return ResponseEntity.ok(students);
        } else {
            logger.warn("No students found for projectId: {}", projectId);
            return ResponseEntity.notFound().build();
        }
    }
}
