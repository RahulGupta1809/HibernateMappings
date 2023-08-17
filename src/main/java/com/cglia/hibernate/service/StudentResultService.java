package com.cglia.hibernate.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.hibernate.bean.StudentResultBean;
import com.cglia.hibernate.repository.StudentResultRepository;


@Service
public class StudentResultService {
    private final StudentResultRepository studentResultRepository;

    @Autowired
    public StudentResultService(StudentResultRepository studentResultRepository) {
        this.studentResultRepository = studentResultRepository;
    }

    public List<StudentResultBean> getResultsWithTotalGreaterThan100() {
        return studentResultRepository.findResultsWithTotalGreaterThan100();
    }
    
    public List<StudentResultBean> getResultsWithTotalLessThan100() {
        return studentResultRepository.findResultsWithTotalLessThan100();
    }
}