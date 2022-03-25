<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="bootstrap.jsp" %>
	<title>Insert title here</title>
</head>
<body class="bg-dark">
	<%@ include file="outter_header.jsp" %>
	<main class="container">
		<div class="row py-4">
			<div class="col-5 d-flex flex-column justify-content-center align-items-center">
				<h1 class="text-white">Register for GotNxt!</h1>
				<form:form action="/reg" method="POST" modelAttribute="user" class="w-75">
					<div class="form-floating mb-3">
						<form:input path="firstName" class="form-control" placeholder="firstname"/>
						<form:label path="firstName">First Name</form:label>
						<form:errors path="firstName" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="lastName" class="form-control" placeholder="lastname"/>
						<form:label path="lastName">Last Name</form:label>
						<form:errors path="lastName" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="userName" class="form-control" placeholder="username"/>
						<form:label path="userName">UserName</form:label>
						<form:errors path="userName" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="email" class="form-control" placeholder="email"/>
						<form:label path="email">Email</form:label>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="password" type="password" class="form-control" placeholder="password"/>
						<form:label path="password">Password</form:label>
						<form:errors path="password" class="text-danger"/>
					</div>
					<div class="form-floating mb-3">
						<form:input path="confirmPassword" type="password" class="form-control" placeholder="confirmpassword"/>
						<form:label path="confirmPassword">Confirm Password</form:label>
						<form:errors path="confirmPassword" class="text-danger"/>
					</div>
					<div class="d-grid mb-5">
					<input type="submit" value="Register" class="btn btn-primary" />
					</div>
				</form:form>
			</div>
			<div class="col-7">
				<div class="carousel slide carousel-fade" id="LoginCarousel" data-bs-ride="carousel" data-bs-pause="hover">
					<div class="carousel-inner">
						<div class="carousel-item active"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-patrick-case-3628912.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh" >
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-pixabay-159607.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-pixabay-207688.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-isabella-mendes-340994.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-mídia-974509.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-pixabay-207714.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-football-wife-1369502.jpg" class="d-block w-100" style="object-fit: cover; object-position: top; height: 80vh">
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>