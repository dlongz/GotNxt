<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="bootstrap.jsp" %>
	<title>Insert title here</title>
</head>
<body class="bg-dark">
	<%@ include file="header.jsp" %>
	<main class="container text-white">
		<h1 class="mb-5 mt-4">${user.userName}'s Events</h1>
		<table class="table table-info table-hover">
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
				<c:forEach items="${hostEvents}" var="event">
				<fmt:formatDate type="date" dateStyle="long" value="${event.date}" var="date"/>
				<fmt:parseDate type="time" var="parsedTime" value="${event.time}" pattern="kk:mm"/>
				<fmt:formatDate type="time" timeStyle="short" value="${parsedTime}" var="time"/>
				<tr>
					<td><a href="/event/${event.id}">${event.title}</a></td>
					<td>${event.sport}</td>
					<td>${event.location}</td>
					<td>${date}</td>
					<td>${time}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>