<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@include file="include/header.jsp" %>
    <h4>Please enter your EMAIL and PASSWORD</h4>

<body>
<p style="color: red">${Error}</p>

<form method="post">
    <table border="1">
        <tr>
            <th>
                <label>Name:
                    <input type="text" name="userName" value="${user.userName}"><br/>
                </label>
            </th>
            <th>
                <label>Password:
                    <input type="password" name="password"><br/>
                </label>
            </th>
        </tr>
    </table>
    <button type="submit">Submit</button>
</form>
<p style="color:forestgreen;">Admin User: Admin password: 12345</p>
<p style="color:forestgreen;">Simple User: User password: 54321</p>

</body>
</head>
</html>
