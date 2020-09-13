<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>MyPage</title>
</head>
<body>
    <h1 align="center" 信息修改页面</h1>
    <div align="center">
        <form action="upload" method="post" enctype="multipart/form-data">
            <p>用户名：<input type="text" id="username" value="" disabled></p>
            <p>上传头像：<input type="file" name="file"/></p>
            <input type="submit" value="提交"/>
        </form>
    </div>
</body>
<script>
    var userinfo = eval("("+sessionStorage.getItem("userinfo")+")");
    document.getElementById("username").value = userinfo.username;
</script>