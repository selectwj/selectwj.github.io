<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/18
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎来到论文管理系统</title>
    <link rel="stylesheet" href="http://localhost:8080/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://localhost:8080/static/css/index.css">
</head>
<body>
<div class="container">
    <div class=" row">
        <div class=" col-md-6 text-center">
            <img src="static/images/head/1.jpg" alt="#">
            <a href="http://localhost:8080/pages/student/login_student.jsp" style="color: white;">
                <button type="button" class=" alert-warning btn btn-default btn-lg">学生登陆</button>
            </a>
        </div>
        <div class=" col-md-6 text-center">
            <img src="static/images/head/2.jpg" alt="#">
            <button type="button" class=" alert-warning btn btn-default btn-lg">教师登陆</button>
        </div>
    </div>
    <div class="row" style="height: 100px;"></div>
    <div class=" row">

    </div>
</div>
<footer class="container-fluid">
    <div class=" row" style="background-color: black;">
        <div class=" col-lg-10">
            NOTFOUND GROUP IN 2022
        </div>
        <div class=" col-lg-2">
            <a href="http://localhost:8080/pages/administrators/login_administrator.jsp" style="color: white;">管理员登录请按这里</a>
        </div>
    </div>
</footer>

<script src="http://localhost:8080/static/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>