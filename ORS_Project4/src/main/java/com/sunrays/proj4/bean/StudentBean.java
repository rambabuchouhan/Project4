package com.sunrays.proj4.bean;

import java.util.Date;

/**
 * Student JavaBean encapsulates Student attributes
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class StudentBean extends BaseBean {
	/**
	 * First Name of Student
	 */
	private String firstName;
	/**
	 * Last Name of Student
	 */

	private String lastName;
	/**
	 * DOB of Student
	 */

	private Date dob;
	/**
	 * Mobile No. of Student
	 */

	private String mobileNo;
	/**
	 * Email of Student
	 */
	private String email;
	/**
	 * CollegeId of of Student
	 */
	private long collegeId;
	/**
	 * College Name of Student
	 */
	private String collegeName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * @Override public String getKey()
	 */

	public String getKey() {
		return id + "";
	}

	/**
	 * @Override public String getValue()
	 */
	public String getValue() {
		return firstName + " " + lastName;
	}

}
