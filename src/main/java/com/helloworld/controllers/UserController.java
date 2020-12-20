package com.helloworld.controllers;

import java.util.List;

import com.helloworld.beans.User;
import com.helloworld.dao.UserDAOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDAOService service;

    /**
     * GET /users. This method retrieve all users and return a json
     */
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    /**
     * GET /users/{id}. This method retrieve a specific user
     */
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        return service.findOne(id);
    }

    /**
     * POST /users/{id}. This method create a user
     */
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User newUser = service.save(user);
    }
}
