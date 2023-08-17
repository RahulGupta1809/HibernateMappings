package com.cglia.hibernate.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cglia.hibernate.bean.StudentResultBean;

public interface StudentResultRepository extends JpaRepository<StudentResultBean, Integer> {
	@Query("SELECT sr FROM StudentResultBean sr WHERE sr.math + sr.science + sr.english >= 100")
	List<StudentResultBean> findResultsWithTotalGreaterThan100();

	@Query("SELECT sr FROM StudentResultBean sr WHERE sr.math + sr.science + sr.english < 100")
	List<StudentResultBean> findResultsWithTotalLessThan100();

}