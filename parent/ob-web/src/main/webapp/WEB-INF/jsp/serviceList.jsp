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
        <td>Type of Service</td>
        <td>Name of Service</td>
        <td>Description</td>
    </tr>
    </thead>
    <tbody>

    <tr>
        <jsp:useBean id="listService" scope="request" type="java.util.List"/>
        <c:forEach items="${listService}" var="service">
        <th><c:out value="${service.typeOfService}"/></th>
        <th><c:out value="${service.nameOfService}"/></th>
        <th><c:out value="${service.description}"/></th>

    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>