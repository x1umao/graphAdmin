package com.ntu.graphadmin.controller;

import com.ntu.graphadmin.entity.User;
import com.ntu.graphadmin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    UserService userService = new UserService();

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println(user);
        if(userService.verifyUser(user)){
            model.addAttribute("username",user.getUsername());
            return "admin-dash";
        }else{
            return "login";
        }
    }
}
