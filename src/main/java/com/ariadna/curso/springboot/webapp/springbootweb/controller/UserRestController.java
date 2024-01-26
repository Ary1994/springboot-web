package com.ariadna.curso.springboot.webapp.springbootweb.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariadna.curso.springboot.webapp.springbootweb.models.User;
import com.ariadna.curso.springboot.webapp.springbootweb.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto=new UserDto();
        User user= new User("ariadna", "garcia");
        userDto.setTitle("El titulo");
        userDto.setUser(user);
        return userDto;
    }

    @GetMapping("/details-maps")
    public Map<String,Object> detailsMap(){
        Map<String,Object> body= new HashMap<>();
        User user= new User("ariadna", "garcia");
        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);
        return body;
    }

}
