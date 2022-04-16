package com.yasin.school_spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/403")
    public String notAuthorized(){
        return"403";
    }
}
