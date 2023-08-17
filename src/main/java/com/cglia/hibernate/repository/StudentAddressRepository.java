package com.cglia.hibernate.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cglia.hibernate.bean.StudentAddressBean;



public interface StudentAddressRepository extends JpaRepository<StudentAddressBean,Integer>{

}
