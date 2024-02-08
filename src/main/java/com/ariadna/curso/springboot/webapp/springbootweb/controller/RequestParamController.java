package com.ariadna.curso.springboot.webapp.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ariadna.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.ariadna.curso.springboot.webapp.springbootweb.models.dto.ParamsDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false,defaultValue ="ingresar un mensaje" ) String message){
        ParamDto param=new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamsDto bar(@RequestParam String text,@RequestParam Integer code) {
        ParamsDto param =new ParamsDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
    }

    @GetMapping("/request")
    public ParamsDto request(HttpServletRequest request) {
        Integer code =0;
        try{
            code=Integer.parseInt(request.getParameter("code"));
        }catch(NumberFormatException e){
        }

        ParamsDto params=new ParamsDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));


        return params;
    }
    
    
}
