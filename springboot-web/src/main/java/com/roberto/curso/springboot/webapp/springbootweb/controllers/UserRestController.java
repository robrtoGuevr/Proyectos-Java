package com.roberto.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.roberto.curso.springboot.webapp.springbootweb.models.User;
import com.roberto.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")    
    public UserDto details(){
        
        User user = new User("Roberto", "Guevara");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola mundo en Spring Boot");
        //Map<String, Object> body = new HashMap<>();
       // body.put("tittle", );
        //body.put("user", user);
        return userDto;
    }

    @GetMapping("/list")    
    public List<User> list(){
        User user = new User("Roberto", "Guevara");
        User user2 = new User("Mario", "Serrano");
        User user3 = new User("Pepe", "Guevara");

        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    @GetMapping("/details-map")    
    public Map<String, Object> detailsMap(){
        User user = new User("Roberto", "Guevara");
        Map<String, Object> body = new HashMap<>();
        body.put("tittle", "Hola mundo en Spring Boot");
        body.put("user", user);
        return body;
    }
}
