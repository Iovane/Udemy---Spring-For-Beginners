package com.practice.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    // create mapping for "/hello"
    @GetMapping("/hello")
    public String hello(Model theModel){
        theModel.addAttribute("theDate", new Date());

        return "hello";
    }
}
