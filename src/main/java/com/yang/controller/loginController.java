package com.yang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

@Controller
public class loginController {
    @RequestMapping(value = "/login")
    public String loginController(HttpRequestHandlerServlet requestHandlerServlet) {



        return "chatroom";
    }

}
