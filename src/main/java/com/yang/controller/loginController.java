package com.yang.controller;


import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String loginController(String username, String password, Model model) {
        User checkUser = userService.getUSerByUsernameAndPassword(username, password);

        if (checkUser == null) {
            model.addAttribute("msg","登录失败");

            return "login";
        }

        return "chatroom";
    }

    @RequestMapping("/getUserById")
    public String getUserById(Integer id, Model model) {

        User user = userService.getUserById(id);

        model.addAttribute("user",user);

        return "user";
    }

}
