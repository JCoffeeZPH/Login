<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <style type="text/css">
        body{
            background-repeat: no-repeat;
            background-position: center;
        }

    </style>
</head>
<body>
<div style="text-align:center;margin-top: 120px">
    <form action="/RegisterServlet" method="post">
        <table style="margin-left:40%">
            <caption>用户注册</caption>
            <tr>
                <td>ID:</td>
                <td><input name="id" type="text" size="20"></td>
            </tr>
            <tr>
                <td>登录名：</td>
                <td><input name="name" type="text" size="20"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="20"></td>
            </tr>
            <tr>
                <td>角色:</td>
                <td><input name="role" type="text" size="20"></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="Login.jsp">登录</a>
    </form>
</div>

</body>
</html>
