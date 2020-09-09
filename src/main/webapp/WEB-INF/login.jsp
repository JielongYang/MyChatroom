<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>


<h1 align="middle">登录页面</h1>
<form action="chatroom" method="post">
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
	<div align="middle"><input type="submit" value="登录" id="bt"></div>
	<div align="middle"><button ><a href="/MyChatroom/toRegister">注册</a></button></div>
</form>
</body>
<head>
		<meta charset="UTF-8">
		<meta http-equiv="content-type" content="text/html;charset=UTF-8">
		<title>login</title>
	</head>
</html>
<script src="https://www.jq22.com/jquery/jquery-3.3.1.js"></script>

<script>
	document.getElementById("bt").addEventListener("click", function(){
		var username = $('#username').val();
		var userinfo = {
			username:username
		};
		sessionStorage.setItem("userinfo",JSON.stringify(userinfo));
	});

</script>
