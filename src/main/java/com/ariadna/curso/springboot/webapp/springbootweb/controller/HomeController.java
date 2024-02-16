package com.ariadna.curso.springboot.webapp.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"","/","/home"})
    public String home() {
        //redirect refresca la url y se puede los datos 
        return "forward:/list";
    }
    

}
