<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/29
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试文件上传</title>
</head>
<body>
<form action="/ajaxServlet" method="post" enctype="multipart/form-data">
    用户名： <input type="text" name="username"><br>
    头像： <input type="file" name="photo"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
