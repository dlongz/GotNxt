<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="bootstrap.jsp" %>
	<title>GotNxt</title>
</head>
<body class="bg-dark">
	<%@ include file="outter_header.jsp" %>
	<main class="container">
		<div class="row py-4">
			<div class="col-7">
				<div class="carousel slide carousel-fade" id="LoginCarousel" data-bs-ride="carousel" data-bs-pause="hover">
					<div class="carousel-inner">
						<div class="carousel-item active"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-cameron-casey-1152853.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh" >
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-jermaine-ulinwa-3225889.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-nappy-936021.jpg" class="d-block w-100" style="object-fit: cover; object-position: top; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-pixabay-258395.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-pixabay-262524.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-rachel-xiao-773063.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
						<div class="carousel-item"> <!-- style="object-fit: cover" -->
							<img alt="" src="/images/pexels-tim-mossholder-1080884.jpg" class="d-block w-100" style="object-fit: cover; object-position: center; height: 80vh">
						</div>
					</div>
				</div>
			</div>
			<div class="col-5 d-flex flex-column justify-content-center align-items-center">
					<h4 class="text-white mb-3">Log In to GotNxt</h4>
					<form:form action="/login" method="POST" modelAttribute="loginUser" class="w-75 mb-3">
						<div class="form-floating mb-3">
							<form:input path="userName" class="form-control" placeholder="username"/>
							<form:label  path="userName" >UserName</form:label>
							<form:errors path="userName" class="text-danger"/>
						</div>
						<div class="form-floating mb-3">
							<form:input path="password" type="password" class="form-control" placeholder="password"/>
							<form:label path="password">Password</form:label>
							<form:errors path="password" class="text-danger"/>
						</div>
						<div class="d-grid mb-5">
						<input type="submit" value="LogIn" class="btn btn-primary"/> 
						</div>
					</form:form>
					
					<p class="text-white">Not A Member? Sign up <a href="/reg">here</a>!</p>
			</div>
		</div>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>