# MyChatroom

Java后台练习小项目

框架：spring + springMVC + Mybatis

基本页面如下：

<img src="https://github.com/blacksheep380/MyChatroom/raw/master/img/登录页面.PNG" alt="登录页面" style="zoom: 60%;" />
<img src="https://github.com/blacksheep380/MyChatroom/raw/master/img/注册页面.PNG" alt="注册页面" style="zoom:60%;" />
<img src="https://github.com/blacksheep380/MyChatroom/raw/master/img/聊天室页面.PNG" alt="聊天室页面" style="zoom:60%;" />
项目结构：
<img src="https://github.com/blacksheep380/MyChatroom/raw/master/img/项目结构.PNG" alt="项目结构" style="zoom:60%;" />


loginController主要用于完成登录验证和注册功能，代码如下：
<img src="https://github.com/blacksheep380/MyChatroom/raw/master/img/loginController.PNG" alt="loginController" style="zoom:60%;" />


项目核心功能是基于WebSocket的在线聊天功能，主要分为JavaScript编写的客户端和Java编写的服务端，由前端发送信息到服务端再广播给其他用户。主要执行流程如下：

1.由客户端发起建立连接并传递用户信息给服务端

2.客户端和服务端的onopen方法同时执行，服务端onopen方法接收用户信息、封装到一个user对象中并存入一个HashMap中。

3.服务端向客户端发送json数据由客户端onmessage方法接收并显示到前端页面。

4.客户端向服务端发送json数据由服务端onmessage方法接收并处理。

更多细节如广播和私聊功能的实现、文件上传功能可自行阅读源码。