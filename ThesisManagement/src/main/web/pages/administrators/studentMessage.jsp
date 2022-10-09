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
    <script type="text/javascript">
        function onSearch(obj){//js函数开始
            setTimeout(function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
                var storeId = document.getElementById('store');//获取table的id标识
                var rowsLength = storeId.rows.length;//表格总共有多少行
                var key = obj.value;//获取输入框的值
                var searchCol = 0;//要搜索的哪一列，这里是第一列，从0开始数起
                for(var i=1;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
                    var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值
                    if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
                        storeId.rows[i].style.display='';//显示行操作，
                    }else{
                        storeId.rows[i].style.display='none';//隐藏行操作
                    }
                }
            },200);//200为延时时间
        }

    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
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
                <li><a href="http://localhost:8080/pages/administrators/studentManagement.jsp">学生管理</a></li>
                <li class="active"><a href="http://localhost:8080/pages/administrators/studentMessage.jsp">学生论文</a></li>
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


    <div > <input name="key" type="text" id="key" onkeydown="onSearch(this)" value="" /></div>
    <div class="starter-template col-lg-2">
        <button type="button" class=" alert-warning btn btn-default btn-lg" id="renewMessageTable">查询数据</button>
    </div>

    <span class="starter-template col-lg-2">
        <form action="http://localhost:8080/downloadServlet" method="post" class="form" id="download">
            <input type="hidden" , name="action" , value="download">
            <button class=" alert-warning btn btn-default btn-lg">下载学生表格</button>
        </form>
        <form action="http://localhost:8080/deleteServlet" method="post" class="form" id="delete">
            <input type="hidden" , name="action" , value="delete">
            <!--输入的用户名保存到username变量，传回后端-->
             学号: <input type="text", name="studentID" value=""><br>
            <button class=" alert-warning btn btn-default btn-lg">删除</button>
        </form>
    </span>
    <span class="starter-template col-lg-8">
        <form action="http://localhost:8080/uploadServlet?action=upload" method="post" enctype="multipart/form-data">
            <input type="file" class=" alert-warning btn-md" name="table" id="">
            <input type="submit" class=" alert-warning btn-md  " value="上传">
        </form>

    </span>
    <table class="table table-striped"  id="store">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>题目</th>
            <th>指导教师</th>
        </tr>
        </thead>
        <tbody id="messageTable">

        </tbody>
    </table>
</div>


<script src="http://localhost:8080/static/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/static/bootstrap/js/bootstrap.min.js"></script>
<script src="http://localhost:8080/static/js/renewTable.js"></script>
</body>
</html>