package com.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

}
