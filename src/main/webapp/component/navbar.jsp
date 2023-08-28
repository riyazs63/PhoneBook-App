<%@ page import="com.model.User"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="index.jsp"><i
		class="fa-solid fa-phone"></i> PhoneBook</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fa-solid fa-house"></i> Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item active"><a class="nav-link"
				href="addContact.jsp"><i class="fa-solid fa-plus"></i> Add Phone
					No</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="viewContact.jsp"><i class="fa-solid fa-eye"></i> View
					Contact</a></li>
		</ul>

		<%
		User u1 = (User) session.getAttribute("user");
		if (u1 == null) {
		%>
		<form class="form-inline my-2 my-lg-0">
			<a href="login.jsp" class="btn btn-success"><i
				class="fa-sharp fa-solid fa-user"></i> Login</a> <a href="Register.jsp"
				class="btn btn-danger ml-2"><i class="fa-solid fa-user"></i>
				Register</a>

		</form>
		<%
		} else {
		%>
		<form class="form-inline my-2 my-lg-0">
			<input type="submit" class="btn btn-success"
				value="<%=u1.getName()%>"> <a data-toggle="modal"
				data-target="#exampleModal" class="btn btn-danger ml-2 text-white">Logout</a>

		</form>
		<%
		}
		%>
	</div>

	<!-- Logout Popup -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Logout Confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
					<h6>Do You Want To Logout</h6>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="logout" class="btn btn-primary">Logout</a>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	<!-- Logout Popup -->
</nav>