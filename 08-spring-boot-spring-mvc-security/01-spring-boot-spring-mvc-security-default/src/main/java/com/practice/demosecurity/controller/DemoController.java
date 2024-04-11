package com.practice.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("leaders")
    public String leadersPage(){
        return "leaders";
    }

    @GetMapping("systems")
    public String adminsPage(){
        return "admins";
    }


}
