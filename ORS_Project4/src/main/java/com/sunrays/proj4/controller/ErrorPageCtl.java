package com.sunrays.proj4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrays.proj4.util.ServletUtility;
@WebServlet(name = "ErrorPageCtl", urlPatterns = { "/ErrorPageCtl" })
public class ErrorPageCtl extends BaseCtl{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
		return;
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
		return;
	}
	
	
	
	@Override
	protected String getView() {
		return ORSView.ERROR_VIEW;
	}

}
