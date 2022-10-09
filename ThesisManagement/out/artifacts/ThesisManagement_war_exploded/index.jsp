<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录页面</title>
    <style>
        body {
            background-image: url("http://localhost:8080/static/images/3.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed; /*图片铺满整个页面*/
        }

        .main {
            width: 500px;
            height: 300px;
            box-shadow: 0 5px 20px 0 #e8e8e8;
            background-color: white;
            border-radius: 10px;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
        }

        .main h2 {
            color: lightseagreen;
            margin-left: 150px;
        }

        .form {
            margin-top: 30px;
            margin-left: 60px;
        }

        .form input {
            width: 300px;
            height: 25px;
            border: 1px solid lightgray;
            outline: none; /*输入内容时不显示边框*/
        }

        .form button {
            width: 300px;
            height: 30px;
            border-style: none;
            font-size: 15px;
            margin-top: 15px;
            cursor: pointer; /*光标放到上面有小手*/
        }

        .msg_cont {

            background: none repeat scroll 0 0 #fff6d2;
            border: 1px solid #ffe57d;
            color: #666;
            height: 18px;
            line-height: 18px;
            padding: 3px 10px 3px 40px;
            position: relative;
            border: none;
        }
    </style>
    <%--  地址栏显示的图片--%>
    <link rel="icon" type="image/x-icon" href="http://localhost:8080/static/images/head/1.jpg">
</head>
<body>
<div class="main">
    <h2>管理员登录</h2>
    <div class="msg_cont">
        <b></b>
        <span class="errorMsg">
            <%=request.getAttribute("msg") == null ? "请输入用户名和密码" : request.getAttribute("msg")%>
        </span>
    </div>
    <form action="http://localhost:8080/administratorServlet" method="post" class="form" id="login">
        用户名:
        <input type="hidden" , name="action" , value="login">
        <input type="text" , name="username" ,id="username",
               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"
        ><br>    <!--输入的用户名保存到username变量，传回后端-->
        密码 : <input type="password" , name="password" ,id="password"><br>
        <button>登录</button>
        <br>
        <a href="http://localhost:8080/pages/administrators/administratorRegister.jsp">
            <input type="button" value="注册">
        </a>
    </form>
</div>
</body>
<script src="http://localhost:8080/static/js/jquery-3.6.0.min.js"></script>

</html>