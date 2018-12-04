package com.webService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebController {

    @RequestMapping("/getInfo")
    public String getInfo(){

        return "this is a get info test";
    }
}
