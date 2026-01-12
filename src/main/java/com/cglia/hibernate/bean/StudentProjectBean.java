package com.cglia.hibernate.bean;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Student_project_information", catalog = "rahul_g")
public class StudentProjectBean {
    @Id
    @Column(name = "project_Id", unique = true, nullable = false)
    private int projectId;

    @Column(name = "project_Name")
    private String projectName;
    @Column(name = "date_Of_Finish")
    private String dateOfFinish;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<StudentBean> students = new ArrayList<>();

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(String dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<StudentBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }

	public StudentProjectBean(int projectId, String projectName, String dateOfFinish, List<StudentBean> students) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.dateOfFinish = dateOfFinish;
		this.students = students;
	}

	public StudentProjectBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
