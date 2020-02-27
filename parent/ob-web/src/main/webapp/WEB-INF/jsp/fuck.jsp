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
    <title>Fuck</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/include/meny.jsp" %>
<h2>Fuck fuck fuck</h2>
<table class="simple-little-table" cellspacing='0'>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="make">
        <tr>
            <td><c:out value="${make.id}"/></td>
            <th><c:out value="${make.name}"/></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
