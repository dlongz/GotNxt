<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="bootstrap.jsp" %>
	<title>GotNxt</title>
</head>
<body class="bg-dark">
	<%@ include file="header.jsp" %>
	<main class="container text-white">
		<h1 class="mb-5 mt-4">Welcome ${user.userName}!</h1>
		
		<div class="d-flex flex-column">
			<h3>Upcoming Events</h3>
			<table class="table table-responsive-md table-primary">
				<thead>
					<tr>
						<th>Event Title</th>
						<th>Sport</th>
						<th>Location</th>
						<th>Date</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${event}" var="event">
						<tr>
					<!-- ***Date and Time Formatter*** -->
						<fmt:formatDate type="date" dateStyle="long" value="${event.date}" var="date"/>
						<fmt:parseDate type="time" var="parsedTime" value="${event.time}" pattern="kk:mm"/>
						<fmt:formatDate type="time" timeStyle="short" value="${parsedTime}" var="time"/>
							<td><a href="/event/${event.id}">${event.title}</a></td>
							<td>${event.sport}</td>
							<td><a href="/event/${event.id}/maps" >${event.location}</a></td>
							<td>${date}</td>
							<td>${time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>