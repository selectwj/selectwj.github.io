<%@ page import="java.util.List" %>
<%@ page import="Entity_class.Package_Get" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/12/29
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
        }
    </style>
</head>
<body>
    <%
        List <Package_Get> packageGetList  =  new ArrayList<Package_Get>();


    %>
    <table>
        <%for (Package_Get package_get : packageGetList) { %>
            <tr>
                <td><%=package_get.getNumber()%></td>
                <td><%=package_get.getAddressee()%></td>
                <td><%=package_get.getAddressee_telephone()%></td>
                <td><%=package_get.getCreate_at()%></td>
            </tr>
        <%}%>
    </table>


</body>
</html>
