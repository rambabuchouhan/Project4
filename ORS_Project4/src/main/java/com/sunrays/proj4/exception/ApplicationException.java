package com.sunrays.proj4.exception;
/**
 * ApplicationException is propogate from service classes when business logic exception occured
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class ApplicationException extends Exception {
	
	public ApplicationException(String msg){
		super(msg);
		
	}

}
