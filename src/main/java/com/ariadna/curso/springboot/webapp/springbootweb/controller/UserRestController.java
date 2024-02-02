package com.ariadna.curso.springboot.webapp.springbootweb.controller;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariadna.curso.springboot.webapp.springbootweb.models.User;
import com.ariadna.curso.springboot.webapp.springbootweb.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;





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
    @GetMapping("/list")
    public List<User> list(){
        User user= new User("Ariadna", "Garcia");
        User user2= new User("Pablo", "Garcia");
        User user3= new User("Jhon", "Doe");

        List<User> users =Arrays.asList(user,user2,user3);
        // List<User>list=new ArrayList<>();
        // list.add(user);
        // list.add(user2);
        // list.add(user3);
        return users;

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
