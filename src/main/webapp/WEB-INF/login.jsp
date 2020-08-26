<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="content-type" content="text/html;charset=UTF-8">
		<title>login</title>
	</head>
	<body>
	<h1 align="middle">登录页面</h1>
	<form action="login" method="post">
	    <table border="0" align="center" >
	        <tr>
	            <td>用户名</td>
	            <td><input type="text" name="name"></td>
	        </tr>
	        <tr>
	            <td>密码</td>
	            <td><input type="text" name="password"></td>
	        </tr>
	        <tr>
	            <td><input type="submit" value="登录"></td>
	        </tr>
	    </table>
	</form>
	</body>
</html>
