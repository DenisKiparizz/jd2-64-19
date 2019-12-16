<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale scope="session" value="${param.lang}"/>
<fmt:setBundle basename="messages"/>



<div style="float: right; padding: 15px; text-align: right;">
    <div>
<%--        <c:if test="${user!=null}"> Hello <b>${user.userName}</b>--%>
        <div>
            <button onclick="location.href='/logout'">Quite account</button>
        </div>
<%--        </c:if>--%>
    </div>
</div>

