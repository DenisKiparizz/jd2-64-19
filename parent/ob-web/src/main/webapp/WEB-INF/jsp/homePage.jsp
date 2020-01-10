<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="${param.lang}">
<head>
    <style>
        <%@include file="/WEB-INF/css/mainMenuImage.css"%>
    </style>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="shortcut icon" href="https://upload.wikimedia.org/wikipedia/en/b/b5/West_Coast_Customs.png"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/include/meny.jsp"%>
<%@include file="/WEB-INF/jsp/include/header.jsp"%>


<h1>Welcome</h1>
<p>We realy glad to see you </p>
</body>
</html>