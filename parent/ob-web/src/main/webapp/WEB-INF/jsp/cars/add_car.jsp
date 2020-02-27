<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head lang="${param.lang}">
    <fmt:setLocale scope="session" value="${param.lang}"/>
    <fmt:setBundle basename="messages"/>
    <title>Make an order</title>
</head>
<body>
<form method="post">
    <h3>First of all full information about car</h3>
    <select id="make" name="make_id">
        <jsp:useBean id="make" scope="request" type="java.util.List"/>
        <c:forEach items="${make}" var="make">
            <option value="${make.id}">${make.name}</option>
        </c:forEach>
    </select>
    <select id="model" name="model_id">
        <jsp:useBean id="model" scope="request" type="java.util.List"/>
        <c:forEach items="${model}" var="model">
            <option value="${model.id}">${model.name}</option>
        </c:forEach>
    </select>
    <select id="body" name="body_id">
        <jsp:useBean id="body" scope="request" type="java.util.List"/>
        <c:forEach items="${body}" var="body">
            <option value="${body.id}">${body.typeOfBody}</option>
        </c:forEach>
    </select>

    <br>
    <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>

</form>

</body>
</html>
