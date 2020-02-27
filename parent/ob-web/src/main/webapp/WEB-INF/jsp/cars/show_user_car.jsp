<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="auth" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListService</title>
    <style>
        <%@ include file="/WEB-INF/css/carTable.css" %>
    </style>
</head>
<body>
<%@include file="/WEB-INF/jsp/include/meny.jsp" %>
<h2>Madels</h2>
<table class="simple-little-table" cellspacing='0'>
    <thead>
    <tr>
        <td>Id</td>
        <td>Make</td>
        <td>Model</td>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="userCar" scope="request" type="java.util.List"/>
    <c:forEach items="${userCar}" var="userCar">
        <tr>
            <td><c:out value="${userCar.id}"/></td>
            <th><c:out value="${userCar.make.name}"/></th>
            <th><c:out value="${userCar.name   }"/></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
