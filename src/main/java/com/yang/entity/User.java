package com.yang.entity;


import com.alibaba.fastjson.JSONObject;

import javax.websocket.Session;

public class User {
    Integer id;
    String username;
    String password;
    private Session session;
    private byte[] head;
    private String headPath;


    public User(Integer id, String username, String password, String headPath) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headPath = headPath;
    }
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.headPath = "";
    }
    public User(String username, String headPath) {
        this.username = username;
        this.headPath = headPath;
    }

//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    public User(String username,Session session) {
        this.username = username;
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public byte[] getHead() {
        return head;
    }

    public void setHead(byte[] head) {
        this.head = head;
    }

    public String getUserinfo(){
        JSONObject job = new JSONObject();
        job.put("username",username);
        return job.toString();
    }
}
