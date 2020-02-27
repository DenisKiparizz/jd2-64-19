<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registration</title>
    <%@include file="/WEB-INF/jsp/include/header.jsp" %>
    <style>
                <%@ include file="/WEB-INF/css/login.css" %>
    </style>
    <h4>Welcome to registration</h4>
</head>
<body>
<p style="color:  red" >${ErrorInput}</p>
<div class="login">
    <h1>Registration</h1>
    <form method="post">
        <input type="text" name="firstName" placeholder="First Name" value="${user.firstName}" required="required"/>
        <input type="text" name="secondName" placeholder="Second Name"  value="${user.secondName}" required="required"/>
        <input type="text" name="userName" placeholder="User Name"  value="${user.userName}" required="required"/>
        <input type="password" name="password" placeholder="Password"  required="required"/>
        <input type="password" name="repeatPassword" placeholder="Repeat Password"  required="required"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>
    </form>
    <p style="color:#dc0013;">Admin User: Admin password: 12345</p>
    <p style="color:#dc0013;">User User: User password: 12345</p>
</div>
</form>
</body>
</html>
