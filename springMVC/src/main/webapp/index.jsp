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

    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"return/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name":"王耀"}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.name);
                    }
                });

            });
        });

    </script>

</head>
<body>
    <h3>Hello World</h3>
    <%--超链接,发生请求--%>
    <a href="hello/say">Say Hello</a><br/>

    <a href="param/hello?name=Hello">绑定参数</a><br/>

    <%--可以封装基本类型,String,JavaBean,集合--%>
    <form action="param/bean" method="post">
        id:<input type="text" name="id"/><br/>
        uid:<input type="text" name="uid"/><br/>
        钱:<input type="text" name="money"/><br/>
        用户姓名<input type="text" name="user.name">
        <input type="submit" name="提交"/><br/>
    </form>

    <%--可以定义如何转换--%>
    <form action="param/converter" method="post">
        用户姓名<input type="text" name="name">
        用户生日<input type="text" name="birthday">
        <input type="submit" name="提交"/><br/>
    </form>

    <a href="return/string">返回类型为String</a>

    <%--默认跳到与方法同名的jsp--%>
    <a href="return/void">返回类型为void</a>

    <a href="return/modelAndView">返回类型为modelAndView</a><br/>

    <a href="return/forwardOfRedirect">使用forward和redirect请求转发</a><br/>

    <button id="btn">发生ajax请求</button><br/>

    <form action="file/upLoad" enctype="multipart/form-data" method="post">
        选择文件:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form><br/>

    <%--使用MultipartFile--%>
    <form action="file/upload2" enctype="multipart/form-data" method="post">
        选择文件:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form><br/>

    <br/><br/>
    <a href="Exception/Exception">测试异常</a><br/>
</body>
</html>
