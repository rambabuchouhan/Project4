
package com.sunrays.proj4.bean;


/**
 * Course JavaBean encapsulates Course attributes
 * 
 * @author Sunilos
 * @version 1.0
 * @copyright (c) SunilOS
 * 
 */
public class CourseBean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Name of Course
	 */
	private String name;
	/**
	 * Description of Course
	 */
	private String description;
	/**
	 * Duration of Course
	 */
	private String duration;
	/**
	 * Acceser
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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
