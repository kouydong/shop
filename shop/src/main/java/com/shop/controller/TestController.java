package com.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class TestController {

    @Autowired
    private int aaa;

    @GetMapping(value="/")
    public String testControllerStart() {

        return "Hello World";
    }

}
