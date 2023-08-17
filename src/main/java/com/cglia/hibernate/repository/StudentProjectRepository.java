package com.cglia.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cglia.hibernate.bean.StudentProjectBean;

public interface StudentProjectRepository extends JpaRepository<StudentProjectBean, Integer> {

}