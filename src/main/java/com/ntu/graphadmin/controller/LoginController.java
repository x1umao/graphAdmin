package com.ntu.graphadmin.controller;

import com.ntu.graphadmin.entity.User;
import com.ntu.graphadmin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public Map<String, Integer> login(@ModelAttribute User user, HttpServletRequest request) {
        System.out.println(user);
        Map<String, Integer> resData = new HashMap<>();
        resData.put("msg", userService.verifyUser(user,request));
        return resData;
    }


}
