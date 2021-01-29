<%@page import="com.sunrays.proj4.controller.GetMarksheetCtl"%>
<%@page import="com.sunrays.proj4.util.DataUtility"%>
<%@page import="com.sunrays.proj4.util.ServletUtility"%>
<%@ page errorPage="ORSView.ERROR_VIEW"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Get Marksheet</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<jsp:useBean id="bean" class="com.sunrays.proj4.bean.MarksheetBean"
		scope="request"></jsp:useBean>

	<center>
		<br> <BR>
		<h1>Get Marksheet</h1>
		<H2>
			<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
			</font> <font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
			</font>
		</H2>
		<br>
		<form action="<%=ORSView.GET_MARKSHEET_CTL%>" method="post">

<tr>
			<input type="hidden" name="id" value="<%=bean.getId()%>"><label>Roll
				No:</label>&emsp; <input type="text" name="rollNo"
				placeholder="Enter Roll Number" size="25"
				value="<%=ServletUtility.getParameter("rollNo", request)%>">	
				
			
			<input type="submit" name="operation"
				value="<%=GetMarksheetCtl.OP_GO%>"> <input type="submit"
				name="operation" value="<%=GetMarksheetCtl.OP_RESET%>"><br><br>
				<font color="red"><%=ServletUtility.getErrorMessage("RollNo", request)%></font></tr>
				<br>
			<%
				if (bean.getRollNO() != null && bean.getRollNO().trim().length() > 0) {
					int phy = bean.getPhysics();
					int chem = bean.getChemistry();
					int math = bean.getMaths();
					int total = phy + chem + math;
					float percentage = total / 3;
			%>
			<font style="font-family: serif; font-style: oblique; font-size: 25">
				<br>
			<%if((bean.getId())>0){ %>
			<table border="1" bgcolor="White" width="55%">
					<b>

						<tr width="50">
							<td height="35">Roll No : <%=DataUtility.getStringData(bean.getRollNO())%></td>
							<td height="35">Name : <%=DataUtility.getStringData(bean.getName())%></td>
						</tr>
				</table>
				<table border="1" bgcolor="White" width="55%">
					<tr>
						<td height="35">Subject Name</td>

						<td height="35">Maximum Marks</td>

						<td height="35">Minimum Marks</td>

						<td height="35">Obtained Marks</td>

						<td>Distinction</td>
					</tr>
					<tr>
						<td height="35">Physics</td>

						<td height="35">100</td>

						<td height="35">33</td>

						<td height="35"><%=phy%></td>
						<td height="35">
							<%
						if (phy >= 75) {
					%> <font color="green"> (Dist) *</font> <%
						}
					%>
						</td>
					</tr>
					<tr>
						<td>Chemistry</td>

						<td>100</td>

						<td>33</td>

						<td><%=chem%></td>
						<td>
							<%
						if (chem >= 75) {
					%> <font color="green">*</font> <%
						}
					%>
						</td>

					</tr>
					<tr>
						<td height="35">Maths</td>

						<td height="35">100</td>

						<td height="35">33</td>

						<td height="35"><%=math%></td>
						<td height="35">
							<%
						if (math >= 75) {
					%> <font color="green">*</font> <%
						}
					%>
						</td>
					</tr>
					<tr>

						<td height="35"></td>
						<td height="35"></td>
						<td height="35">Grand Total</td>

						<td height="35"><%=total%>/300</td>

					</tr>
					<tr>

						<table border="1" bgcolor="white" width="55%">
							<%
						if (percentage >= 60 && chem >= 33 && math >= 33 && phy >= 33) {
					%>
							<td align="right" height="35"><font color="green">PASS
									WITH FIRST DIVISION</font></td>
							<%
						} else if (percentage >= 45 && percentage < 60 && chem >= 33 && math >= 33 && phy >= 33) {
					%>
							<td align="right"><font color="green">PASS WITH
									SECOND DIVISION</font></td>
							<%
						} else if (percentage >= 33 && percentage < 45 && chem >= 33 && math >= 33 && phy >= 33) {
					%><td height="35"><font color="green">PASS WITH THIRD
									DIVISION</font></td>
							<%
						} else if (chem < 33 || math < 33 || phy < 33) {
					%><td align="right"><font color="red">FAIL IN <%
					 	if (chem < 33) {
					%> CHEMISTRY</td>
							<%
						}
								if (math < 33) {
					%>MATHS
							</td>
							<%
						}
								if (phy < 33) {
					%>PHYSICS
							</font>
							</td>
							<%
						}
					%>
							<%
						}
					%>
							</tr>
						</table>
						</b>
				</table>  
				
				<table>
				<tr>
					<td align="right"><input type="button" name="submit"
						onclick="history.back()"
						value="<%=GetMarksheetCtl.OP_BACK%>"></td>
				</tr>
			</table>
				<%}else{}
				}
			%>
			</font>
		</form>
	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="Footer.jsp"%>
</body>
</html>
