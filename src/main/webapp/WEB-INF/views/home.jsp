<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
	<link href="<c:url value="/resources/home.css" />" rel="stylesheet">
</head>
<body>

<Div>
	<H4>Shortest path details:</H4>
	<div>
		<c:forEach items="${shortestRoute}" var="planet">
	    	<div class='code'>${planet.planetName}[${planet.planetCode}]</div>
		</c:forEach>
	</div>
</Div>
</body>
</html>