package com.roberto.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.roberto.curso.springboot.webapp.springbootweb.models.User;



@Controller
public class UserController {
    @GetMapping("/details")    
    public String details(Model model){
        User user = new User("Roberto", "Guevara");
        user.setEmail("roberto@gmail.com");
        model.addAttribute("tittle", "Hola mundo en Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users = Arrays.asList(
        new User("pepe","Gonzalez"), 
        new User("lalo","Perez"),
        new User("roberto","Guevara"));

        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }
}
