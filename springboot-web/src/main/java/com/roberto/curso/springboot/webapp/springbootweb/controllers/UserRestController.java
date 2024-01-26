package com.roberto.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.curso.springboot.webapp.springbootweb.models.User;



@RestController
@RequestMapping("/api")
public class UserRestController {
    User user = new User("Roberto", "Guevara");

    @GetMapping("/details")    
    public Map<String, Object> details(){
        Map<String, Object> body = new HashMap<>();
        body.put("tittle", "Hola mundo en Spring Boot");
        body.put("user", user);
        return body;
    }
}
