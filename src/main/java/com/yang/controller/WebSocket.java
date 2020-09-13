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
    private static ConcurrentHashMap<String,User> users = new ConcurrentHashMap<>();
    private User user;

    @OnOpen
    public void onOpen(@PathParam("userinfo")String userinfo, Session session) throws IOException {
        String decodedUserinfo = decodeBase64(userinfo);
        JSONObject job = JSONObject.parseObject(decodedUserinfo);
        String username = job.getString("username");
        User user = new User(username,session);
        this.user = user;
        users.put(username,user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type","login");
        jsonObject.put("content",username);
        jsonObject.put("namelist",users.keySet());
        //向所有用户推送新用户进入消息
        for (String key:users.keySet()) {
            users.get(key).getSession().getBasicRemote().sendText(jsonObject.toString());
        }


    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        JSONObject jsob = JSONObject.parseObject(message);
        if (jsob.get("sendTo").equals("public")) {
            for (String key:users.keySet()) {
                users.get(key).getSession().getBasicRemote().sendText(jsob.toString());
            }
        } else {
            String self = (String) jsob.get("from");
            String toUser = (String) jsob.get("sendTo");
            users.get(toUser).getSession().getBasicRemote().sendText(jsob.toString());
            users.get(self).getSession().getBasicRemote().sendText(jsob.toString());
        }

        return;

    }
    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
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

}
