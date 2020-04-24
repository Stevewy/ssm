<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/4/23
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h3>Hello World</h3>
    <%--超链接,发生请求--%>
    <a href="hello/say">Say Hello</a><br/>

    <a href="param/hello?name=Hello">绑定参数</a><br/>

    <form action="param/bean" method="post">
        id:<input type="text" name="id"/><br/>
        uid:<input type="text" name="uid"/><br/>
        钱:<input type="text" name="money"/><br/>
        用户姓名<input type="text" name="user.name">
        <input type="submit" name="提交"/><br/>
    </form>

</body>
</html>
