package com.example.email.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tecontroller {


    @RequestMapping("/123")
    public String sdas(){
        return "qweqw";
    }

}
