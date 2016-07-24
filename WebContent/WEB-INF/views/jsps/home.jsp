<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/static/css/main.css" />
<title>Strongerweb</title>
</head>
<body>
<h1>Welcome</h1>
<h2>Let's get started.</h2>
<h3>Enter what you know:</h3>
<form action="#" id="initial-data-form" th:action="@{/createprofile}" th:object="${human}" method="post">
	<p><label>My max squat is</label><input type="text" name="maxbarbellbacksquatweight" /> pounds for <input type="text" name="squatreps"><label>reps</label></p>
	<p><label>My max bench is</label><input type="text" name="maxbarbellbenchpressweight" /> pounds for <input type="text" name="squatreps"><label>reps</label><br /></p>
	<p><label>My weight is</label><input type="text" th:field="*{weightInPounds}" name="myweight" /> pounds<br /></p>
	<p>I am a <label for="male">Man</label><input th:field="*{sex}" type="radio" th:value="*{male}" name="sex" id="male" />
	<label for="woman">Woman</label><input th:field="*{sex}" type="radio" name="sex" th:value="*{female}" id="female" /></p>
	<p><button type="submit">Submit</button></p>
</form>
<br /><br />
<p><a href="newuser">Create account</a></p>
<br />
<h3>Current users:</h3>
<c:forEach var="row" items="${userAccounts}">
${row.username}<br />

</c:forEach>

</body>
</html>