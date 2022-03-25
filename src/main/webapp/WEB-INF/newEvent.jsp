<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="bootstrap.jsp" %>
	<title>GetNxt</title>
</head>
<body class="bg-dark">
	<%@ include file="header.jsp" %>
	<main class="container">
		<div class="d-flex flex-column justify-content-center align-items-center">
			<h1 class="text-white mb-4 mt-4">Create A New Event!</h1>
			
			<form:form action="/event/create" method="post" modelAttribute="eventForm" class="w-50">
				<div class="form-floating mb-3">
					<form:input path="title" class="form-control" placeholder="title"/>
					<form:label path="title">Event Title</form:label>
					<form:errors path="title" class="text-danger"/>
				</div>
				<div class="form-floating mb-3">
					<form:input path="sport" class="form-control" placeholder="sport"/>
					<form:label path="sport">Sport</form:label>
					<form:errors path="sport" class="text-danger"/>
				</div>
				<div class="form-floating mb-3">
					<form:input path="location"  class="form-control" placeholder="location"/>
					<form:label path="location">Location</form:label>
					<form:errors path="location" class="text-danger"/>
				</div>
				<div class="form-floating mb-3">
					<form:input path="date" type="date"  class="form-control" placeholder="date"/>
					<form:label path="date">Date</form:label>
					<form:errors path="date" class="text-danger"/>
				</div>
				<div class="form-floating mb-3">
					<form:input path="time" type="time" class="form-control" placeholder="time"/>
					<form:label path="time">Time</form:label>
					<form:errors path="time" class="text-danger"/>
				</div>
				<div class="form-floating mb-3">
					<form:textarea path="details" class="form-control" placeholder="details" style="height:200px"/>
					<form:label path="details">Details</form:label>
					<form:errors path="details" class="text-danger"/>
				</div>
				<form:hidden path="host" value="${user.id}"/>
				<div class="d-grid mb-3">
					<input type="submit" value="Create Event" class="btn btn-primary"/>
				</div>
			</form:form>
		</div>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>