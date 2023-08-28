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
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-sucess">Login Page</h4>
						<%
						String invalidMsg = (String) session.getAttribute("invalidMsg");
						if (invalidMsg !=null)
						{%>
							<p class="text-danger text-center"><%=invalidMsg%></p>	
						<%
						session.removeAttribute("invalidMsg");}
						%>
						
						
						<%
						String logoutmsg = (String) session.getAttribute("logoutmsg");
						if (logoutmsg !=null)
						{%>
							<p class="text-success text-center"><%=logoutmsg%></p>	
						<%
						session.removeAttribute("logoutmsg");}
						%>
						
						
						<form action="login" method="post">

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
								<input type="submit" class="btn btn-success" value="Login">

							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>