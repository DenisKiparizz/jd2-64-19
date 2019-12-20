<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Service</title>
</head>
<body>
<h1>Welcome to add service menu</h1>
<h3>Add new services for your car</h3>
<form method="post" action="${pageContext.request.contextPath}/add">
    <label> Name: <input type="text" name="nameOfService"></label>
    <br>
    <label> description: <input type="text" name=description></label>
    <br>
    <input type="submit">
</form>
</body>
</html>
