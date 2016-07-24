<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Strongerweb: New User</title>
</head>
<body>
<h1>Start today</h1>
<form class="newUserForm" method="POST" action="${pageContext.request.contextPath}/docreate" >
<label>Username:</label> <input name="username" type="text" /><br />
<label>Set password:</label><input name="password" type="text" /><br />
<input name="submit" value="Begin" type="submit" />

</form>
<p><a href="#">Assign random username and password and login</a></p>
</body>
</html>