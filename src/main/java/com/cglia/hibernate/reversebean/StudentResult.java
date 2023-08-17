package com.cglia.hibernate.reversebean;
// Generated Aug 4, 2023, 9:49:41 AM by Hibernate Tools 6.0.2.Final

/**
 * StudentResult generated by hbm2java
 */
public class StudentResult implements java.io.Serializable {

	private int resultId;
	private Integer english;
	private Integer math;
	private Integer science;

	public StudentResult() {
	}

	public StudentResult(int resultId) {
		this.resultId = resultId;
	}

	public StudentResult(int resultId, Integer english, Integer math, Integer science) {
		this.resultId = resultId;
		this.english = english;
		this.math = math;
		this.science = science;
	}

	public int getResultId() {
		return this.resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public Integer getEnglish() {
		return this.english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getMath() {
		return this.math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

	public Integer getScience() {
		return this.science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

}
