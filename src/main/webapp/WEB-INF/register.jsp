<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1 align="middle">注册页面</h1>
<form action="register" method="post">
    <table border="0" align="center" >
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>${msg}</td>
        </tr>
    </table>
    <div align="middle"><input type="submit" value="注册"></div>
</form>
    <div align="middle"><button id="returnToLogin">返回登录</button</div>
</body>
</html>
<script src="https://www.jq22.com/jquery/jquery-3.3.1.js"></script>
<script>
    $("#returnToLogin").click(function () {
        window.location.href = "returnToLogin";
    });
</script>