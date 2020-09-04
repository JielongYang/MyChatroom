package com.yang.entity;


import com.alibaba.fastjson.JSONObject;

import javax.websocket.Session;

public class User {
    Integer id;
    String username;
    String password;
    private Session session;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
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

    public String getUserinfo(){
        JSONObject job = new JSONObject();
        job.put("username",username);
//        job.put("avatar",avatar);
//        job.put("nickname",nickname);
        return job.toString();
    }
}
