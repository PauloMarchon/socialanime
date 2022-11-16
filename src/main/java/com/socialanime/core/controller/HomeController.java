package com.socialanime.core.controller;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/")
public class HomeController {

    public String home(Principal principal){
        return "Hello " + principal.getName();
    }
}
