package com.cglia.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student_address", catalog = "rahul_g")
public class StudentAddressBean {
	@Id
	@Column(name = "addressId", unique = true, nullable = false)
	private int addressId;

	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "type_Of_Address")
	private String typeOfAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	@JsonIgnore
	private StudentBean student;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypeOfAddress() {
		return typeOfAddress;
	}

	public void setTypeOfAddress(String typeOfAddress) {
		this.typeOfAddress = typeOfAddress;
	}

	public StudentBean getStudent() {
		return student;
	}

	public void setStudent(StudentBean student) {
		this.student = student;
	}

	public StudentAddressBean(int addressId, String city, String state, String typeOfAddress, StudentBean student) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.typeOfAddress = typeOfAddress;
		this.student = student;
	}

	public StudentAddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	// Constructors, getters, and setters
}
