<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <h4>Please enter your EMAIL and PASSWORD</h4>

<body>
<p style="color: red">${Error}</p>

<form method="post">
    <label>Name:
        <input type="text" name="userName"><br/>
    </label>
    <label>Password:
        <input type="password" name="password"><br/>
    </label>
    <button type="submit">Submit</button>
</form>

</body>
</head>
</html>
