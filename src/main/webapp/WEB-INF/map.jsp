<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="ISO-8859-1">
  	<%@ include file="bootstrap.jsp" %>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      /* /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      
      /* Optional: Makes the sample page fill the window. */
     
    </style>
    <script src="/javascript/map.js"></script>
  </head>
  <body class="bg-dark">
  	<%@ include file="header.jsp" %>
  	<fmt:formatDate type="date" var="date" dateStyle="long" value="${event.date}"/>
	<fmt:parseDate type="time" var="parsedTime" value="${event.time}" pattern="kk:mm"/>
	<fmt:formatDate type="time" var="time" timeStyle="short" value="${parsedTime}" />
  	<main class="container">
  		<div class="row py-4" style="height: 80vh">
	  		<div class="col-4 text-white">
	  			<h1>${event.title}</h1>
	  			<aside class="">
					<p>Where?: <span id="address">${event.location}</span></p>
					<p>When?: ${date} ${time}</p>
					<p>What?: ${event.details}</p>
				</aside>
	  		</div>
	  		<div class="col-8">
	    		<div id="map" class="h-100"></div>
	  		</div>
  		</div>
  	</main>
    
    <script async
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA2BI1uY7ZD1HP0Fd90z0zh6FITzcCp6Wc&libraries=places&callback=initMap">
</script>
  </body>
</html>