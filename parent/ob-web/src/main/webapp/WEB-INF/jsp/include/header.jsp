<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale scope="session" value="${param.lang}"/>

<c:if test="${param.lang != null}">
    <% session.setAttribute("car_service_locate", request.getParameter("lang")); %>
</c:if>
<c:if test="${sessionScope.car_service_locate != null}">
    <fmt:setLocale value="${sessionScope.car_service_locate}"/>
</c:if>


<fmt:setBundle basename="messages"/>

<div style="float:  right; padding: 15px; text-align: right;">
    <div>
        <c:if test="${user!=null}"> Nice to see you <b>${user.userName}</b>
            <div>
                <button onclick="location.href='${pageContext.request.contextPath}/logout'">Quite account</button>
            </div>
        </c:if>
    </div>
</div>

<div style="flood-color: crimson; padding: 20px; text-align: left;">
    <div style="color: red">
        <c:if test="${user==null}">
            First of all input LOGIN and PASSWORD
        </c:if>
    </div>
</div>
<div>
    <div style="float: right; padding: 15px; text-align: right;">
        <a href="?lang=en">en</a> |
        <a href="?lang=ru">ru</a>
    </div>
</div>
