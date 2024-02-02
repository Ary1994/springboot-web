package com.ariadna.curso.springboot.webapp.springbootweb.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ariadna.curso.springboot.webapp.springbootweb.models.User;



@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user= new User("ariadna", "garcia");
        //user.setEmail("ary@gmail.com");
        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);


        return"details";
    }


    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("title","listado de usuarios");
        
        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel(){

       return Arrays.asList(
        new User("Pepa","Rodriguez")
        ,new User("Ariadna","Garcia","ary@gmail.com")
        ,new User("Jhon","Doe")
        ,new User("Juanita","Roe"));
    }
}

