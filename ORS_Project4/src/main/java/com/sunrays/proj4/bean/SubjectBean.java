package com.sunrays.proj4.bean;

/**
 * Subject JavaBean encapsulates Subject attributes
 * 
 * @author SunilOS
 * @version 1.0
 * @copyright (c) SunilOS
 * 
 */
public class SubjectBean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Name of Subject
	 */
	private String name;
	/**
	 * Description of Subject
	 */
	private String description;
	/**
	 * CourseId of Course
	 */

	private long CourseId;
	/**
	 * Course Name of Course
	 */
	private String CourseName;
	/**
	 * accessor
	 
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCourseId() {
		return CourseId;
	}

	public void setCourseId(long courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
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

		return name;
	}

}
