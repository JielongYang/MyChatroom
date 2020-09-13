<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" lang="en">
    <title>MyChatroom</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style>
        p {
            text-align: left;
            padding-left: 20px;
        }
    </style>
</head>
<body>
<div style="width: 800px;height: 600px;margin: 30px auto;text-align: center">
    <h1>Speechless Chat</h1>
    <div style="width: 800px;border: 1px solid gray;height: 300px;">
        <div style="width: 200px;height: 300px;float: left;text-align: left;">
            <p><span>当前在线:</span><span id="user_num">0</span></p>
            <div id="user_list" style="overflow: auto;">

            </div>
        </div>
        <div id="msg_list" style="width: 598px;border:  1px solid gray; height: 300px;overflow: scroll;float: left;">

        </div>
    </div>
    <br>
    <div style="height:auto ; width: auto"><span id="sendTo"></span> <button onclick="changeToPublic()" >群聊模式</button><button id="toMyPage">我的页面</button> </div>
    <textarea id="msg_box" rows="6" cols="50" onkeydown="confirm(event)"></textarea><br>
    <input type="button" value="发送" onclick="send()">
</div>
</body>
</html>
<script src="https://www.jq22.com/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript">
    //获取用户登录信息
    var userinfo = eval("("+sessionStorage.getItem("userinfo")+")");
    var encodeUserinfo = window.btoa(encodeURIComponent(sessionStorage.getItem("userinfo")));
    var url = "ws://localhost:8080/MyChatroom/WebSocketLink/" + encodeUserinfo;
    if ('WebSocket' in window) {
        var ws = new WebSocket(url);
    }else {
        alert('当前浏览器不支持WebSocket')
    }

    ws.onopen = function () {

    };

    ws.onmessage = function (ev) {
        var msg = JSON.parse(ev.data);
        var sender,user_name, name_list, change_type;

        switch (msg.type) {
            case 'system':
                sender = '系统消息: ';
                break;
            case 'user':
                sender = msg.from + ': ';
                break;
            case 'login':
                user_name = msg.content;
                name_list = msg.namelist;
                change_type = msg.type;
                dealUser(user_name, change_type, name_list);
                return;
        }
        var data = sender + msg.content;
        listMsg(data);
    };

    ws.onerror = function () {
        var data = "系统消息 : 出错了,请退出重试.";
        listMsg(data);
    };

    ws.onclose = function (ev) {
        listMsg(ev);
    }


    /**
     * 在输入框内按下回车键时发送消息
     *
     * @param event
     *
     * @returns {boolean}
     */
    function confirm(event) {
        var key_num = event.keyCode;
        if (13 == key_num) {
            send();
        } else {
            return false;
        }
    }

    /**
     * 发送并清空消息输入框内的消息
     */
    //一个标记私聊或是群发的flag
    var sendTo = "public";
    function send() {
        var msg_box = document.getElementById("msg_box");
        var content = msg_box.value;
        var msg = {'content': content.trim(), 'type': 'user','from':userinfo.username,'sendTo':sendTo};
        sendMsg(msg);
        msg_box.value = "";
    }

    function chatWith(name) {
        if (name != userinfo.username) {
            sendTo = name;
            var str = "正在和"+ name + "聊天";
            document.getElementById("sendTo").innerText = str;
        }
    }
    $("#toMyPage").click(function () {
        window.location.href = "toMyPage";

    });
    function changeToPublic() {
        document.getElementById("sendTo").innerText = "";
        sendTo = "public";
    }

    /**
     * 将消息内容添加到输出框中,并将滚动条滚动到最下方
     */
    function listMsg(data) {
        var msg_list = document.getElementById("msg_list");
        var msg = document.createElement("p");
        var head = document.createElement("img");
        head.setAttribute("src","img/" + userinfo.username + ".png");

        // var img = "<img href = " + "C:/javaProject/MyChatroom/" + userinfo.username
        msg.innerHTML = data;
        msg_list.appendChild(msg);
        msg_list.scrollTop = msg_list.scrollHeight;
    }

    /**
     * 处理用户登陆消息
     *
     * @param user_name 用户名
     * @param type  login/logout
     * @param name_list 用户列表
     */
    function dealUser(user_name, type, name_list) {
        var user_list = document.getElementById("user_list");
        var user_num = document.getElementById("user_num");
        while(user_list.hasChildNodes()) {
            user_list.removeChild(user_list.firstChild);
        }

        for (var index in name_list) {
            var user = document.createElement("p");
            user.innerHTML = name_list[index];
            user.setAttribute('onclick','chatWith("'+name_list[index]+'")');
            user_list.appendChild(user);
        }
        user_num.innerHTML = name_list.length;
        user_list.scrollTop = user_list.scrollHeight;
        var change = type == 'login' ? '上线' : '下线';

        var data = '系统消息: ' + user_name + ' 已' + change;

        listMsg(data);
    }

    /**
     * 将数据转为json并发送
     * @param msg
     */
    function sendMsg(msg) {
        var data = JSON.stringify(msg);
        ws.send(data);
    }

</script>