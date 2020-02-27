<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/tablib/auth.tld" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="auth" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        <%@ include file="/WEB-INF/css/carTable.css" %>
    </style>
    <title>ListService</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/include/meny.jsp" %>
<h2>There are your orders</h2>
<table class="simple-little-table" cellspacing='0'>
    <thead>
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Second Name</td>
        <td>Username</td>
        <td>Role</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersList}" var="users">
        <tr>
            <td><c:out value="${users.id}"/></td>
            <th><c:out value="${users.firstName}"/></th>
            <th><c:out value="${users.secondName}"/></th>
            <th><c:out value="${users.userName}"/></th>
            <th><c:out value="${users.role}"/></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
