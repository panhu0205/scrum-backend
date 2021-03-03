package com.user.controllers;

import java.lang.ModuleLayer.Controller;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.exceptions.IDNotAcceptedException;
import com.exceptions.UserNotFoundException;
import com.user.beans.User;
import com.user.dao.UserDAOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    public EntityModel<User> retrieveUser(@PathVariable Integer id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        // HATEOAS
        // "all-users"
        // https://stackoverflow.com/questions/55770163/resource-and-controllerlinkbuilder-not-found-and-deprecated
        EntityModel<User> resource = EntityModel.of(user);
        Link link = linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users");
        resource.add(link);
        link = linkTo(methodOn(this.getClass()).retrieveUser(2)).withRel("user-2");
        resource.add(link);
        return resource;
    }

    /**
     * GET /users/{id}. This method retrieve a specific user
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        User user = service.deleteByID(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }

    /**
     * POST /users/{id}. This method create a user
     * 
     * update 21/12/2020: Enhance the POST to return the correct status code. In
     * this situation, return 201 created instead of 200 OK.
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if (user.getId() < 0) {
            throw new IDNotAcceptedException("fuck you" + user.getId());
        }
        User newUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
