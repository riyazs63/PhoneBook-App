
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.Dao.UserDao"%>
<%@page import="java.util.*"%>
<%@page import="com.model.Contact"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #f7f7f7;
}
</style>

</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%
	if (u1 == null) {
		session.setAttribute("invalidMsg", "Please Login...");
		response.sendRedirect("login.jsp");
	}
	%>

	<%
	String successMsg = (String) session.getAttribute("successMsg");
	if (successMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=successMsg%></div>

	<%
	session.removeAttribute("successMsg");
	}
	%>


	<div class="container">
		<div class="row p-4">

			<%
			if (u1 != null) {

				ArrayList<Contact> al = UserDao.displayContact(u1.getId());

				for (Contact c : al) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name:
							<%=c.getName()%></h5>
						<p>
							Contact:
							<%=c.getPhno()%></p>
						<p>
							email:
							<%=c.getEmail()%></p>
						<p>
							About:
							<%=c.getAbout()%></p>
						<div class="text-center">
							<a class="btn btn-success btn-sm text-white"
								href="editcontact.jsp?id=<%=c.getId()%>">Edit</a> <a
								href="<%=request.getContextPath()%>/delete?id=<%=c.getId()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			}
			%>


		</div>
	</div>
</body>
</html>