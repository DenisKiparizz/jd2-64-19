<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="${param.lang}">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>

<%@include file="include/header.jsp"%>
<h2><fmt:message key="home.page.header"/></h2>



<%@include file="include/menu.jsp"%>

<h2><fmt:message key="home.page.text"/> </h2>
<h1><fmt:message key="home.page.text1"/> </h1>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
