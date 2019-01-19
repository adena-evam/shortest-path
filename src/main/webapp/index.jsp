<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
	<link href="<c:url value="/resources/home.css" />" rel="stylesheet">
</head>
<body>
	<div id='container'>
		<form action="getPath" method='POST'>
			<div style="margin: 5px 0">
				<div class='lable'>Source:</div>
				<div class='inputbox'>
					<input type="text" name="source" value="" />
				</div>
			</div>
			<div style="margin: 5px 0">
				<div class='lable'>Destination:</div>
				<div class='inputbox'>
					<input type="text" name="destination" value="" />
				</div>
			</div>
			<div style="margin: 5px 0">
				<div class='lable'>&nbsp;</div>
				<div class='inputbox'>
					<input type="submit" value="submit" />
				</div>
			</div>
		</form>
	</div>

</body>
</html>
