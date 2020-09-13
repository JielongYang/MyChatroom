package com.yang.controller;
import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
    @Autowired
    private UserService userService;
    //登录验证
    @RequestMapping(value = "/chatroom")
    public String loginController(String username, String password, Model model) {
        User checkUser = userService.getUSerByUsernameAndPassword(username, password);
        if (checkUser == null) {
            model.addAttribute("msg","登录失败");
            return "login";
        }
        return "chatroom";
    }
    //注册
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

    //登录注册之间的页面跳转
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }
    @RequestMapping("/returnToLogin")
    public String returnToLogin() {
        return "login";
    }



}
