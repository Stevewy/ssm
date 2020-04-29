<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/4/29
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="user/findAll">测试查询所有信息</a>

    <form action="user/save" method="post">
        姓名:<input type="text" name="username"><br>
        生日:<input type="text" name="birthday"><br>
        性别:<input type="text" name="sex"><br>
        地址:<input type="text" name="address"><br>
        <input type="submit" value="保存"><br>
    </form>
</body>
</html>
