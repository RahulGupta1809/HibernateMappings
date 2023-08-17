package com.cglia.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cglia.hibernate.bean.StudentBean;

@Repository
@EnableJpaRepositories

public interface StudentRepository extends JpaRepository<StudentBean, Long> {

}