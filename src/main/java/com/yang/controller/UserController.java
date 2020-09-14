package com.yang.controller;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toMyPage")
    public String toMyPage(){
        return "myPage";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadPic(MultipartFile file, String username) throws IOException {
        String fileName = file.getOriginalFilename();
        String path = "C:/javaProject/MyChatroom/img/" + fileName;
        File file1 = new File(path);
        userService.upload(path, username);
        file.transferTo(file1);

        return "MyChatroom";
    }

    @RequestMapping("/changeUsername")
    public String changeUsername(String username,String newUsername) {
        userService.updateUsername(username, newUsername);

        return "myPage";
    }

    @RequestMapping("/returnToChatroom")
    public String returnToChatroom() {
        return "chatroom";
    }
}
