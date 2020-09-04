package com.yang.controller;

import org.springframework.stereotype.Controller;

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


@Controller
@ServerEndpoint("/WebSocketLink/{userinfo}")
public class WebSocket {

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

    }

    @OnOpen
    public void onOpen(Session session) {


    }

    @OnClose
    public void onClose() {

    }
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("WebSocket发生错误");
        error.printStackTrace();
    }
}
