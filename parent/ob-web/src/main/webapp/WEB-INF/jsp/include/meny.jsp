<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <style>
        <%@ include file="/WEB-INF/css/main.css" %>
    </style>
</head>
<body>
<div class="icon-bar">
    <h3 style="margin-top: 10px">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <a href="${pageContext.request.contextPath}/list">Car List</a>
<%--        <a href="${pageContext.request.contextPath}/listService">Service List</a>--%>
        <a href="${pageContext.request.contextPath}/addOrder">New Order</a>
        <a href="${pageContext.request.contextPath}/login">Login</a>
        <a href="${pageContext.request.contextPath}/about">About</a>
    </h3>
</div>