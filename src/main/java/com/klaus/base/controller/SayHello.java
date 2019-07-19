package com.klaus.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }
}
