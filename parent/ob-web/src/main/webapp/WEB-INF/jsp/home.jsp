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
<h4>Welcome to main menu West Cost Customs</h4>
<h5> We really glad to see you in our company and bla bla bla</h5>
<%@include file="include/header.jsp"%>
<%@include file="include/menu.jsp"%>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
