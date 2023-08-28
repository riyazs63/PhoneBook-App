<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.User"%>
<%@ page import="com.model.Contact"%>
<%@ page import="com.Dao.UserDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
</head>
<body>

	<%@include file="component/navbar.jsp"%>

	<%
	if (u1 == null) {
		session.setAttribute("invalidMsg", "Please Login...");
		response.sendRedirect("login.jsp");
	}
	%>

	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-sucess">Edit Contact Page</h4>

						<%
						String SuccessMsg = (String) session.getAttribute("successMsg");
						String ErrorMsg = (String) session.getAttribute("failedMsg");
						if (SuccessMsg != null) {
						%>
						<p class="text-success text-center"><%=SuccessMsg%></p>

						<%
						session.removeAttribute("successMsg");
						}

						if (ErrorMsg != null) {
						%>
						<p class="text-danger text-center"><%=ErrorMsg%></p>
						<%
						session.removeAttribute("failedMsg");

						}
						%>



						<form action="update" method="post">

							<%
							int cid = Integer.parseInt(request.getParameter("id"));
							Contact c = UserDao.editContact(cid);
							%>

							<input type="hidden" value="<%=c.getId()%>" id="id" name="id">

							<div class="form-group">
								<label for="name">Enter Name</label> <input type="text"
									class="form-control" id="name" name="name"
									value="<%=c.getName()%>" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="email">Email address</label> <input type="email"
									class="form-control" id="email" name="email"
									value="<%=c.getEmail()%>" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="phoneno">Enter Phone No </label> <input
									type="number" class="form-control" id="phoneno" name="phoneno"
									value="<%=c.getPhno()%>" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="about" name="about"
									placeholder="Enter About" value="<%=c.getAbout()%>"
									aria-describedby="emailHelp">
							</div>

							<div class="text-center mt-2">
								<input type="submit" class="btn btn-success"
									value="Update Contact">

							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>