package com.sunrays.proj4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sunrays.proj4.bean.BaseBean;
import com.sunrays.proj4.bean.StudentBean;
import com.sunrays.proj4.bean.UserBean;
import com.sunrays.proj4.exception.ApplicationException;
import com.sunrays.proj4.exception.DuplicateRecordException;
import com.sunrays.proj4.model.RoleModel;
import com.sunrays.proj4.model.StudentModel;
import com.sunrays.proj4.model.UserModel;
import com.sunrays.proj4.util.DataUtility;
import com.sunrays.proj4.util.DataValidator;
import com.sunrays.proj4.util.PropertyReader;
import com.sunrays.proj4.util.ServletUtility;

@WebServlet(urlPatterns={"/ctl/UserCtl"})
public class UserCtl extends BaseCtl {
	
	 private static final long serialVersionUID = 1L;

	    private static Logger log = Logger.getLogger(UserCtl.class);

	    @Override
	    protected void preload(HttpServletRequest request) {
	        RoleModel model = new RoleModel();
	        try {
	            List l = model.list();
	            System.out.println(l);
	            request.setAttribute("roleList", l);
	           
	        } catch (ApplicationException e) {
	        	e.printStackTrace();
	            log.error(e);
	        }

	    }

	    @Override
	    protected boolean validate(HttpServletRequest request) {

	        log.debug("UserCtl Method validate Started");

	        boolean pass = true;

	        String login = request.getParameter("login");
	        String dob = request.getParameter("dob");


			if (DataValidator.isSpace(request.getParameter("firstName"))) {
				request.setAttribute("firstName", PropertyReader.getValue("", "First Name"));
				pass = true;
			}
			if (DataValidator.isWhiteSpace(request.getParameter("firstName"))) {
				request.setAttribute("firstName", PropertyReader.getValue("error.white", "First Name"));
				pass = false;
			}

			
			if (DataValidator.isNull(request.getParameter("firstName"))) {
				request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));

				pass = false;

			} else if (!DataValidator.isName(request.getParameter("firstName"))) {
				request.setAttribute("firstName", PropertyReader.getValue("error.Name", "First Name"));

				pass = false;
			}


	        if (DataValidator.isNull(request.getParameter("lastName"))) {
	            request.setAttribute("lastName",
	                    PropertyReader.getValue("error.require", "Last Name"));
	            pass = false;
	        }

	        if (DataValidator.isNull(login)) {
	            request.setAttribute("login",
	                    PropertyReader.getValue("error.require", "Login Id"));
	            pass = false;
	        } else if (!DataValidator.isEmail(login)) {
	            request.setAttribute("login",
	                    PropertyReader.getValue("error.email", "Login "));
	            pass = false;
	        }

	        if (DataValidator.isNull(request.getParameter("password"))) {
				request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
				pass = false;
			} else if (!DataValidator.isPassword(request.getParameter("password"))) {
				request.setAttribute("password", PropertyReader.getValue("error.pass", "Password"));

				pass = false;
	        }
	        

	        if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
	            request.setAttribute("confirmPassword", PropertyReader.getValue(
	                    "error.require", "Confirm Password"));
	            pass = false;
	        } 
	        if (!request.getParameter("password").equals(
	                request.getParameter("confirmPassword"))
	                && !"".equals(request.getParameter("confirmPassword"))) {
	            request.setAttribute("confirmPassword", PropertyReader.getValue("error.cpassword","Confirm Password"));
	            pass = false;
	        }

	        if (DataValidator.isNull(request.getParameter("gender"))) {
	            request.setAttribute("gender",
	                    PropertyReader.getValue("error.require", "Gender"));
	            pass = false;
	        }
	        if (DataValidator.isNull(request.getParameter("roleId"))) {
	            request.setAttribute("roleName", PropertyReader.getValue(
	                    "error.require", "roleName "));
	          
	            pass = false;
	        }
	        if (DataValidator.isNull(request.getParameter("mobileNo"))) {
				request.setAttribute("MobileNo", PropertyReader.getValue("error.require", "Mobile No"));
				pass = false;
			} else if (!DataValidator.isLong(request.getParameter("mobileNo"))) {
				request.setAttribute("MobileNo", PropertyReader.getValue("error.mobile1", "Mobile No"));

				pass = false;
			} else if (!DataValidator.isMobLength(request.getParameter("mobileNo"))) {
				request.setAttribute("MobileNo", PropertyReader.getValue("error.mobilelength", "Mobile No"));

				pass = false;
			} else if (!DataValidator.isMob(request.getParameter("mobileNo"))) {
				request.setAttribute("MobileNo", PropertyReader.getValue("error.mobile", "Mobile No"));

				pass = false;
			}


	        if (DataValidator.isNull(dob)) {
	            request.setAttribute("dob",
	                    PropertyReader.getValue("error.require", "Date Of Birth"));
	            pass = false;
	        } else if (!DataValidator.isDate(dob)) {
	            request.setAttribute("dob",
	                    PropertyReader.getValue("error.date", "Date Of Birth"));
	            pass = false;
	        }
	        
	        

	        log.debug("UserCtl Method validate Ended");

	        return pass;
	    }

	    @Override
	    protected BaseBean populateBean(HttpServletRequest request) {

	        log.debug("UserCtl Method populatebean Started");

	        UserBean bean = new UserBean();

	        bean.setId(DataUtility.getLong(request.getParameter("id")));

	        bean.setRoleId(DataUtility.getInt(request.getParameter("roleId")));
	        bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

	        bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));

	        bean.setLastName(DataUtility.getString(request.getParameter("lastName")));

	        bean.setLogin(DataUtility.getString(request.getParameter("login")));

	        bean.setPassword(DataUtility.getString(request.getParameter("password")));

	        bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));

	        bean.setGender(DataUtility.getString(request.getParameter("gender")));
            bean.setMobileNo(DataUtility.getStringData(request.getParameter("mobileNo")));
	        bean.setDob(DataUtility.getDate(request.getParameter("dob")));
	     

	        populateDTO(bean, request);

	        log.debug("UserCtl Method populatebean Ended");

	        return bean;
	    }

	    
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        log.debug("UserCtl Method doGet Started");
	        String op = DataUtility.getString(request.getParameter("operation"));
	        // get model
	        	
	        UserModel model = new UserModel();
	        long id = DataUtility.getLong(request.getParameter("id"));
	        if (id > 0 || op != null) {
	            System.out.println("in id > 0  condition");
	            UserBean bean;
	            try {
	                bean = model.findByPK(id);
	                ServletUtility.setBean(bean, request);
	            } catch (ApplicationException e) {
	            	e.printStackTrace();
	                log.error(e);
	                ServletUtility.handleException(e, request, response);
	                return;
	            }
	        }

	        ServletUtility.forward(getView(), request, response);
	        log.debug("UserCtl Method doGet Ended");
	    }

	    
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        log.debug("UserCtl Method doPost Started");
	    
	    String op = DataUtility.getString(request.getParameter("operation"));

		// get model

		UserModel model = new UserModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			UserBean bean = (UserBean) populateBean(request);

			try {
				if (id > 0) {
					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Data is Successfully Updated", request);
				} else {
					long pk = model.add(bean);
					ServletUtility.setSuccessMessage("Data is Successfully Saved", request);
				}
/*				ServletUtility.setBean(bean, request);
*/			//	ServletUtility.setSuccessMessage("Data is Successfully Saved", request);

			}  catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage(" Email Id already exists", request);
			}

		}

		else if (OP_DELETE.equalsIgnoreCase(op)) {

			UserBean bean = (UserBean) populateBean(request);
			try {
				model.delete(bean);
				ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
				return;

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);

		log.debug("StudentCtl Method doPost Ended");
	}

	    @Override
	    protected String getView() {
	        return ORSView.USER_VIEW;
	    }

	}


 