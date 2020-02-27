<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head lang="${param.lang}">
    <fmt:setLocale scope="session" value="${param.lang}"/>
    <fmt:setBundle basename="messages"/>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/updateOrder">
    Type of Repair
    <label>
        <input type="text" name="title" placeholder="title" required="required"/>
    </label>
    <select id="services" name="serviceType_id">
        <jsp:useBean id="services" scope="request" type="java.util.List"/>
        <c:forEach items="${services}" var="name">
            <option value="${name.id}">${name.name}</option>
        </c:forEach>
    </select>

    <br>
    <label>
        <input type="text" name="description" placeholder="description" required="required"/>
    </label>
    <br>
    <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>
</form>

</body>
</html>
