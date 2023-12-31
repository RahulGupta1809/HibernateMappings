package com.cglia.hibernate.reversebean;
// Generated Aug 4, 2023, 9:49:41 AM by Hibernate Tools 6.0.2.Final

/**
 * Employee generated by hbm2java
 */
public class Employee implements java.io.Serializable {

	private int idemployee;
	private String nameemployee;
	private String city;
	private Integer age;

	public Employee() {
	}

	public Employee(int idemployee, String nameemployee) {
		this.idemployee = idemployee;
		this.nameemployee = nameemployee;
	}

	public Employee(int idemployee, String nameemployee, String city, Integer age) {
		this.idemployee = idemployee;
		this.nameemployee = nameemployee;
		this.city = city;
		this.age = age;
	}

	public int getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getNameemployee() {
		return this.nameemployee;
	}

	public void setNameemployee(String nameemployee) {
		this.nameemployee = nameemployee;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
