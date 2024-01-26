package com.ariadna.curso.springboot.webapp.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ariadna.curso.springboot.webapp.springbootweb.models.User;



@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user= new User("ariadna", "garcia");
        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);


        return"details";
    }

}
