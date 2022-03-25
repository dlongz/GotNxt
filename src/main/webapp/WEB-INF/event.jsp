<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="bootstrap.jsp" %>
	<title>GotNxt</title>
</head>
<body class="bg-dark" onload="codeAddress()">
	<%@ include file="header.jsp" %>
	<fmt:formatDate type="date" var="date" dateStyle="long" value="${event.date}"/>
	<fmt:parseDate type="time" var="parsedTime" value="${event.time}" pattern="kk:mm"/>
	<fmt:formatDate type="time" var="time" timeStyle="short" value="${parsedTime}" />
	<main class="container text-white">
		<div class="row h-100 pt-5">
			<div class="col">
				<h1 class="mb-3">${event.title}</h1>
				<p>Where?: <a href="/event/${event.id}/maps" ><span id="address">${event.location}</span></a></p>
				<p>When?: ${date} ${time}</p>
				<p>What?: ${event.details}</p>
<%-- 				<aside><a href="/event/${event.id}/maps" >Maps</a></aside> --%>
			</div>	
			
			<div class="col d-flex flex-column" style="height: 80vh">
				<div class="">
					<c:choose>
						<c:when test="${user.id == event.host.getId()}">
						<div class="w-100 d-flex mb-5">
							<a class="btn btn-warning me-5" href="/event/${event.id}/edit">Edit</a>
							<form:form action="/event/${event.id}/delete" method="delete">
							<!-- <input type="hidden" name="_method" value="delete"/> For normal form only-->
							<input class="btn btn-danger" type="submit" value="Delete" />
							</form:form>
						</div>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${event.athletes.contains(user)}">
								<div class="mb-5">
									<a class="btn btn-danger" href="/event/${eventId}/leave/${user.id}">Cancel</a>
								</div>
								</c:when>
								<c:otherwise>
								<div class="mb-5">
									<a class="btn btn-success" href="/event/${eventId}/join/${user.id}">Join</a>
								</div>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
				<div>
					<h3>Athletes Joining</h3>
					<ul class="list-unstyled">
					<c:forEach items="${event.getAthletes()}" var="athlete">
						<li>${athlete.userName}</li>
					</c:forEach>
					</ul>
				</div>
			</div>				
		</div>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>