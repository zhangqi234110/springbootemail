package com.example.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class WomeController {


    @RequestMapping("/welcome")
    public String wel(){
        return "mail";
    }

}
