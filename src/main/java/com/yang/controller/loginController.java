package com.yang.controller;


import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/chatroom")
    public String loginController(String username, String password, Model model, HttpSession session) {
        User checkUser = userService.getUSerByUsernameAndPassword(username, password);

        if (checkUser == null) {
            model.addAttribute("msg","登录失败");

            return "login";
        }

        return "chatroom";
    }
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }


    @RequestMapping("/register")
    public String registerController(String username, String password, Model model) {

        User checkUsername = userService.getUserByUsername(username);
        if (checkUsername != null) {
            model.addAttribute("msg","用户名已存在");
            return "register";
        }
        User user = new User(username,password);
        userService.insert(user);
        return "login";
    }



}
