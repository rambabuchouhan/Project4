<%@page import="com.sunrays.proj4.util.DataUtility"%>
<%@page import="com.sunrays.proj4.controller.RoleListCtl"%>
<%@page import="com.sunrays.proj4.controller.BaseCtl"%>
<%@page import="com.sunrays.proj4.bean.RoleBean"%>
<%@page import="com.sunrays.proj4.util.ServletUtility"%>
<%@page import="com.sunrays.proj4.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page errorPage="ORSView.ERROR_VIEW"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="bean" class="com.sunrays.proj4.bean.RoleBean"
	scope="request"></jsp:useBean>
<jsp:useBean id="model" class="com.sunrays.proj4.model.RoleModel"
	scope="request"></jsp:useBean>
<jsp:useBean id="model1" class="com.sunrays.proj4.model.RoleModel"
	scope="request"></jsp:useBean>
<html>
<head>
<title>Role List</title>

<style type="text/css">
.td{
text-align: center;
}
</style>
</head>
<body>

	<%@include file="Header.jsp"%>

	<center>
		<h1>Role List</h1>
            
               <%if(ServletUtility.getSuccessMessage(request).length()>0){ %>
			<h2>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h2>
			
			<%}else{ %>
			<h2>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h2>
			<%} %>
               
		<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">
			<table width="100%">
			<%-- <%
						List list = ServletUtility.getList(request);
						if (list.size() == 0 || list == null) {
					%>
				<br>
				<input type="submit" name="operation"
					value="<%=RoleListCtl.OP_BACK %>">

				<%
						} else {
					%>
					
 --%>				
 
 <% List li = (List) request.getAttribute("RoleList"); %>
 <tr>
					<td align="center">&emsp;&emsp;&emsp;&emsp;<label>Name
							:</label><%=HTMLUtility.getList("name", ServletUtility.getParameter("name", request), li)%>
						&nbsp; <input type="submit" name="operation"
						value="<%=RoleListCtl.OP_SEARCH %>"> <input type="submit"
						name="operation" value="<%=RoleListCtl.OP_RESET%>">
					</td>
				</tr>

			</table>
			 <%
						List list = ServletUtility.getList(request);
						if (list.size() == 0 || list == null) {
					%>
				<br>
				<%-- <input type="submit" name="operation" 
					value="<%=CourseListCtl.OP_RESET %>"> --%>
     <%-- <%} %> --%>

				<%
						} else {
					%>
			
			<br>
			<table border="1" width="100%">

				<tr>
					<th align="left" width="90"><input type="checkbox"
						onclick="selectall(this)">Select All</th>
					<th>S.No.</th>

					<th>Name</th>
					<th>Description</th>
					<th>Edit</th>
				</tr>


				<%
                    int pageNo = ServletUtility.getPageNo(request);
                    int pageSize = ServletUtility.getPageSize(request);
                    int index = ((pageNo - 1) * pageSize) + 1;
 
                     list = ServletUtility.getList(request);
                    Iterator<RoleBean> it = list.iterator();
                    while (it.hasNext()) {
                        bean = it.next();
                        RoleBean rolebean = model1.findByPK(bean.getId());
						String rolename = rolebean.getName();
                %>
					<tr class="td">
					<%
						if (rolebean.getId() == 1) {
					%>
					<td><input type="checkbox" name="ids" disabled="disabled"
						value="<%=bean.getId()%>"></td>
					<%
						} else {
					%><td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<%
						}
					%>

					<td><%=index++%></td>

					<td><%=bean.getName()%></td>
					<td><%=bean.getDescription()%></td>

					<td>
						<%
						if (rolebean.getId() == 1) {
					%> --- <%
						} else {
					%><a href="RoleCtl?id=<%=bean.getId()%>">Edit</a> <%
						}
					%>
					</td>
				</tr>
				<%
                    }
                %>
			</table>
			<table width="100%">
				<tr>
					<%
						if (pageNo == 1) {
					%>
					<td><input type="submit" name="operation" disabled="disabled"
						value="<%=RoleListCtl.OP_PREVIOUS%>"></td>

					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>
					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_DELETE%>"></td>

					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_NEW%>"></td>
					<%
					if((model.nextPK()-1) == bean.getId() || (list.size() < pageSize)){
					%>
					<td align="right"><input type="submit" name="operation"
						disabled="disabled" value="<%=RoleListCtl.OP_NEXT%>"></td>
					<%
						} else {
					%><td align="right"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_NEXT%>"></td>
					<%
						}
					%>
				</tr>
			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
			<%
						}
						if (list.size()<=0){
		%>
		<br>
		<center>
		
			<input type="submit" name="operation"
				value="<%=RoleListCtl.OP_BACK%>">
		</center>

		<%
			}
		%>
		</form>
	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="Footer.jsp"%>
</body>
</html>