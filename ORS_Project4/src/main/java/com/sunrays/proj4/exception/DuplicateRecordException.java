package com.sunrays.proj4.exception;
/**
 * DuplicateRecordException is propogate by DAO classes when an duplicate database exception occured
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class DuplicateRecordException extends Exception{
	
	public DuplicateRecordException(String msg){
		super(msg);
	}
	

}
