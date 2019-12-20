<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/tablib/auth.tld" %>
<html>
<head>
    <title>ListService</title>
</head>
<body>
<%@include file="../include/header.jsp"%>
<%@include file="../include/menu.jsp"%>
<h2>There are your orders</h2>
<table class="title title - striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Description</th>
        <th>Id</th>
    </tr>
    </thead>
    <tbody>

    <%--    <jsp:useBean id="list" scope="request" type="java.util.List"/>--%>
    <c:forEach items="${list}" var="models">
        <tr>
            <td><c:out value="${models.nomber}"/></td>
            <td><c:out value="${models.nameOfService}"/></td>
            <td><c:out value="${models.description}"/></td>
            <td><c:out value="${models.id}"/></td>
            <td>
                <a:auth path="/dell">
                    <form method="post">
                        <a href="${pageContext.request.contextPath}/dell">DELL</a>
                    </form>
                </a:auth>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h5>For delite service input nessesary ID</h5>
<form method="post" action="${pageContext.request.contextPath}/dell">
    <label> Delete: <input type="number" name=id> </label>
</form>
<div>    <!-- buttons holder -->
    <button onclick="location.href='/add'">Add new service</button>
    <button onclick="location.href='/update'">Update page</button>
</div>
</body>
</html>