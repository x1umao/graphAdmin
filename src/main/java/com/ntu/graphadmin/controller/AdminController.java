package com.ntu.graphadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @GetMapping("/admin-dash")
    public String adminDash(){
        //获取session id

        //校验用户是否登录

        //填写username

        return "admin-dash";
    }

}
