<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="http://localhost:8080/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://localhost:8080/static/css/begin.css">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">学生论文管理系统后台</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/pages/administrators/begin.jsp">日志管理</a></li>
                <li class="active"><a href="http://localhost:8080/pages/administrators/studentManagement.jsp">学生管理</a></li>
                <li><a href="http://localhost:8080/pages/administrators/studentMessage.jsp">学生论文</a></li>
            </ul>
            <div class="navbar-right">
                <p class="navbar-text">${sessionScope.user.username}用户</p>
                <button type="submit" class="btn btn-success">
                    <a href="http://localhost:8080/administratorServlet?action=logout">注销</a>
                </button>
            </div>
        </div>
    </div>
</nav>

<div class="container">

    <span class="starter-template col-lg-2">
        <button type="button" class=" alert-warning btn btn-default btn-lg" id="renewStudentsTable">查询数据</button>
    </span>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>手机号</th>
        </tr>
        </thead>
        <tbody id="studentsTable">

        </tbody>
    </table>
</div>

<script src="http://localhost:8080/static/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/static/bootstrap/js/bootstrap.min.js"></script>
<script src="http://localhost:8080/static/js/renewTable.js"></script>
</body>
</html>