package com.invillia.sabadell.userquery.controller;

import com.invillia.sabadell.userquery.model.User;
import com.invillia.sabadell.userquery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id) {
        return service.get(id);
    }
}
