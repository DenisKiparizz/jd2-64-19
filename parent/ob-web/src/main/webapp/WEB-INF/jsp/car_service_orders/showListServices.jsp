<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListService</title>
</head>
<body>
<h2>There are your orders</h2>
<table>
    <tr>
        <td>No</td>
        <td>Name</td>
        <td>Description</td>
        <td>Id</td>
    </tr>
    <c:forEach items="${list}" var="models">
        <tr>
            <td><c:out value="${models.nomber}"/></td>
            <td><c:out value="${models.nameOfService}"/></td>
            <td><c:out value="${models.description}"/></td>
            <td><c:out value="${models.id}"/></td>

        </tr>
    </c:forEach>

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