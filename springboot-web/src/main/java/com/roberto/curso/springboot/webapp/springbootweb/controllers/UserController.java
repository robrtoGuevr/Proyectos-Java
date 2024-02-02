package com.roberto.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
          return Arrays.asList(
            new User("Pepe","Gonzalez"), 
            new User("Lalo","Perez", "lalo@gmail.com"),
            new User("Roberto","Guevara", "roberto@gmail.com"),
            new User("Mario","Serrano")
            );
    }
}
