<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="flood-color: crimson; padding: 20px; text-align: left;">
    <div style="color: red">
        <c:if test="${sessionScope.user==null}">
            First of all input LOGIN and PASSWORD
        </c:if>
    </div>
</div>

<div style="float:  right; color: brown; padding-bottom: 35px; text-align: right;">
    <div>
        <c:if test="${sessionScope.user!=null}">
            <a style="color: darkgoldenrod"> Nice to see you </a><b>${user.userName}
            <a style="color: darkgoldenrod"> Your status is </a> <b>${user.role}</b></b>
            <div>
                <button onclick="location.href='${pageContext.request.contextPath}/logout'">Quite account</button>
            </div>
        </c:if>
    </div>
</div>

