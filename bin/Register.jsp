<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
</head>
<body style="background-color: #f7faf8;">
	<%@include file="component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-sucess">Registration Page</h4>
						
						<%
						String SuccessMsg = (String)session.getAttribute("SuccessMsg");
						String ErrorMsg = (String)session.getAttribute("ErrorMsg");
						if(SuccessMsg != null)
						{
						%>
							<p class="text-success text-center"><%=SuccessMsg %></p>
					
						<%
						session.removeAttribute("SuccessMsg");
						}
						
						if (ErrorMsg != null)
						{
						%>
						<p class="text-danger text-center"><%=ErrorMsg %></p>
						<%
						session.removeAttribute("ErrorMsg");

						}
						%>
						
						
						<form action="register" method="post">
							<div class="form-group">
								<label for="name">Enter Name</label> <input
									type="text" class="form-control" id="name"
									name="name" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="email">Email address</label> <input
									type="email" class="form-control" id="email"
									name="email" aria-describedby="emailHelp"
									placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input
									type="password" class="form-control" id="password"
									name="password" placeholder="Password">
							</div>
							<div class="text-center mt-2">
								<input type="submit" class="btn btn-success" value="Register">

							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>