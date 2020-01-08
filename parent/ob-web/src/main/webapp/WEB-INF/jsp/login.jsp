<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Login</title>
    <%@include file="/WEB-INF/jsp/include/header.jsp"%>
    <style>
        <%@ include file="/WEB-INF/css/login.css" %>
    </style>
    <h4>Please enter your EMAIL and PASSWORD</h4>
</head>
<body>
<p style="color: red">${ERROR666}</p>

<div class="login">
    <h1>Login</h1>
    <form method="post">
        <input type="text" name="name" placeholder="Username" value="${user.name}" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>
    </form>
    <p style="color:#dc0013;">Admin User: Admin password: 12345</p>
    <p style="color:#dc0013;">User User: User password: 12345</p>
</div>
</form>
</body>
</html>
