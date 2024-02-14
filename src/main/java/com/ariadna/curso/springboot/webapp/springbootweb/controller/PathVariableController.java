package com.ariadna.curso.springboot.webapp.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariadna.curso.springboot.webapp.springbootweb.models.User;
import com.ariadna.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    // @Value("${config.message}")
    // private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valueString;
    @Value("${config.code}")
    private Long  code;
    
    
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto paramDto =new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }
   @GetMapping("/mix/{product}/{id}")
   public Map<String,Object> mix(@PathVariable String product,@PathVariable Long id){
    Map<String,Object>json=new HashMap<>();
    json.put("product", product);
    json.put("id", id);

    return json;

   } 

   @PostMapping("/create")
   public User createUser(@RequestBody User user) {

      //un save en la base de datos
      user.setName(user.getName().toUpperCase());
       
       return user;
   }
   

   @GetMapping("/values")
   public Map<String,Object> values(@Value("${config.message}") String message){
    Map<String,Object> map=new HashMap<>();
    map.put("message", message);
    map.put("username", username);
    map.put("code", code);
    map.put("listOfValues", listOfValues);
    map.put("valueList", valueList);
    map.put("valueString", valueString);

    return map;

   }

}
