package com.sunrays.proj4.bean;

/**
 * DropdownList interface is implemented by Beans those are used to create drop
 * down list on HTML pages
 * 
 * @author Sunilos
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public interface DropDownListBean {

	/**
	 * Returns key of list element
	 * 
	 * @return key
	 */
	public String getKey();

	/**
	 * Returns display text of list element
	 * 
	 * @return value
	 */
	public String getValue();

}
