<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<h1>Welcome to GotNxt</h1>
		<p><a href="/login">Log In</a></p>
		<p><a href="/reg">Register</a></p>
		<p></p>
	</main>
	<%@ include file="bootstrap_js.jsp" %>
</body>
</html>