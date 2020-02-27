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
        <td>Make</td>
        <td>Model</td>
        <td>Type of Body</td>
        <td>Type of Engine</td>
        <td>Value of engine</td>
        <td>Age</td>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="list" scope="request" type="java.util.List"/>
    <c:forEach items="${list}" var="service">
        <tr>
            <td><c:out value="${service.id}"/></td>
            <th><c:out value="${service.make}"/></th>
            <th><c:out value="${service.model}"/></th>
            <th><c:out value="${service.body}"/></th>
            <th><c:out value="${service.typeOfEngine}"/></th>
            <th><c:out value="${service.valueOfEngine}"/></th>
            <th><c:out value="${service.age}"/></th>
<%--            <a:auth path="/dellCar">--%>
                <th>
                    <form method="post" action='<c:url value="/dellCar" />' style="display:inline;">
                        <input type="hidden" name="id" value="${service.id}">
                        <input type="submit" value="Delete">
                    </form>
                </th>
<%--            </a:auth>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
