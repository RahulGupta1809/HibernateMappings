package com.cglia.hibernate.reversebean;
// Generated Aug 4, 2023, 9:49:41 AM by Hibernate Tools 6.0.2.Final

/**
 * Admin generated by hbm2java
 */
public class Admin implements java.io.Serializable {

	private String email;
	private String password;

	public Admin() {
	}

	public Admin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
