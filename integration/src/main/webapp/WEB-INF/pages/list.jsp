<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/4/29
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>所有信息如下</h3>
    <c:forEach items="${list}" var="user">
        ${user.username}
    </c:forEach>
</body>
</html>
