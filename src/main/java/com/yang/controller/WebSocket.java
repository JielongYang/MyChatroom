package com.yang.controller;

import com.alibaba.fastjson.JSONObject;
import com.yang.entity.User;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.net.URLDecoder;
import java.util.Base64;


@Controller
@ServerEndpoint("/WebSocketLink/{userinfo}")
public class WebSocket {
    private static int onlineCount = 0;
    private static ConcurrentHashMap<String,User> root = new ConcurrentHashMap<>();
    private User user;

    @OnOpen
    public void onOpen(@PathParam("userinfo")String userinfo, Session session) throws IOException {
        String decodedUserinfo = decodeBase64(userinfo);
        JSONObject job = JSONObject.parseObject(decodedUserinfo);
        String username = job.getString("username");
        User user = new User(username,session);
        this.user = user;
        root.put(username,user);
        addOnlineCount();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type",0);
        jsonObject.put("username",username);
        //向除本用户外的其他用户推送该用户信息
        for (String key:root.keySet()) {
            root.get(key).getSession().getBasicRemote().sendText(jsonObject.toString());
        }


    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("onMessage");


        return;

    }

    @OnError
    public void onError(Throwable error){
        System.out.println("WebSocket error");
        error.printStackTrace();
        System.out.println(error.getStackTrace());
        System.out.println(error.toString());
    }

    @OnClose
    public void onClose() {
        System.out.println("closed");
    }

    private static String decodeBase64(String str) throws UnsupportedEncodingException {
        byte[] decoded = Base64.getDecoder().decode(str);
        String decodeStr =  new String(decoded);
        return URLDecoder.decode(decodeStr,"utf-8");
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
