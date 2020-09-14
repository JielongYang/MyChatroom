<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>MyPage</title>
</head>
<body>
    <h1 align="center" >我的页面</h1>
    <div align="center">
        <form action="upload" method="post" enctype="multipart/form-data">
            <p>用户名：<input type="text" id="username" value="" disabled></p>
            <p>上传头像：<input type="file" name="file"/></p>
            <input type="submit" value="提交"/>
        </form>
        <form action="changeUsername" method="post">
            <p>用户名：<input type="text" id="username1" value="" disabled></p>
            <p>修改用户名：<input type="text" id="newUsername"></p>
            <input type="submit" value="提交"/>
        </form>
        <div align="middle"><button id="returnToChatroom">返回聊天室</button></div>
    </div>

</body>
<script src="https://www.jq22.com/jquery/jquery-3.3.1.js"></script>
<script>
    var userinfo = eval("("+sessionStorage.getItem("userinfo")+")");
    document.getElementById("username").value = userinfo.username;
    document.getElementById("username1").value = userinfo.username;
    $("#returnToChatroom").click(function () {
        window.location.href = "returnToChatroom";
    })
</script>