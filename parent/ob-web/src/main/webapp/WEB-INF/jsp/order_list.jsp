<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/tablib/auth.tld" %>
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
<h2>There are all Users</h2>
<table class="simple-little-table" cellspacing='0'>
    <thead>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Service Type</td>
        <td>Description</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="orders">
        <tr>
            <td><c:out value="${orders.id}"/></td>
            <th><c:out value="${orders.title}"/></th>
            <th><c:out value="${orders.serviceT.name}"/></th>
            <th><c:out value="${orders.description}"/></th>
            <th>
                <form method="post" action='<c:url value="/deleteOrder" />' style="display:inline;">
                    <input type="hidden" name="id" value="${orders.id}">
                    <input type="submit" value="Delete">
                </form>
                <form method="post" action='<c:url value="/updateOrder" />' style="display:inline;">
                    <input type="hidden" name="id" value="${orders.id}">
                    <input type="submit" value="Update">
                </form>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
