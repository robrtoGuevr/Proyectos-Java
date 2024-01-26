package com.roberto.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.roberto.curso.springboot.webapp.springbootweb.models.User;



@Controller
public class UserController {
User user = new User("Roberto", "Guevara");
    @GetMapping("/details")    
    public String details(Model model){
        model.addAttribute("tittle", "Hola mundo en Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
}
