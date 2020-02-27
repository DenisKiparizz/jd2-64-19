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
        //Delete
        <a href="${pageContext.request.contextPath}/allCarModel">Model List</a>
        //User
        <a href="${pageContext.request.contextPath}/login">Login</a>
        <a href="${pageContext.request.contextPath}/about">About</a>
        <a href="${pageContext.request.contextPath}/newOrder">New Order</a>
        <a href="${pageContext.request.contextPath}/addMake">Make an order</a>
        //Admin
        <a href="${pageContext.request.contextPath}/usersList">User LIst</a>
        <a href="${pageContext.request.contextPath}/ordersList">Orders</a>
    </h3>
</div>