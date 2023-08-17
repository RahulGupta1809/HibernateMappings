package com.cglia.hibernate.bean;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_information", catalog = "rahul_g")
public class StudentBean {
	@Id
	@Column(name = "student_id", unique = true, nullable = false)
	private int studentId;

	@Column(name = "student_Name")
	private String name;
	@Column(name = "student_gender")
	private String gender;
	@Column(name = "student_email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
	private List<StudentAddressBean> addresses = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resultId")
	private StudentResultBean result;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_project_table", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<StudentProjectBean> projects = new ArrayList<>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentAddressBean> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<StudentAddressBean> addresses) {
		this.addresses = addresses;
	}

	public StudentResultBean getResult() {
		return result;
	}

	public void setResult(StudentResultBean result) {
		this.result = result;
	}

	public List<StudentProjectBean> getProjects() {
		return projects;
	}

	public void setProjects(List<StudentProjectBean> projects) {
		this.projects = projects;
	}

	public StudentBean(int studentId, String name, String gender, String email, List<StudentAddressBean> addresses,
			StudentResultBean result, List<StudentProjectBean> projects) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.addresses = addresses;
		this.result = result;
		this.projects = projects;
	}

	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors, getters, and setters
}