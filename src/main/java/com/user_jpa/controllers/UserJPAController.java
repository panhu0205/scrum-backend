package com.user_jpa.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.exceptions.IDNotAcceptedException;
import com.exceptions.UserNotFoundException;
import com.user_jpa.dao.UserJPADAOService;
import com.user_jpa.beans.UserJPA;
import com.user_jpa.repo.UserRepository;

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
public class UserJPAController {

    @Autowired
    private UserJPADAOService service;

    @Autowired
    private UserRepository userRepository;

    /**
     * GET /users. This method retrieve all users and return a json
     */
    @GetMapping("/jpa/users")
    public List<UserJPA> retrieveAllUsers() {
        return userRepository.findAll();
    }

    /**
     * GET /users/{id}. This method retrieve a specific user
     */
    @GetMapping("/jpa/users/{id}")
    public EntityModel<UserJPA> retrieveUser(@PathVariable Integer id) {
        Optional<UserJPA> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        // HATEOAS
        // "all-users"
        // https://stackoverflow.com/questions/55770163/resource-and-controllerlinkbuilder-not-found-and-deprecated
        EntityModel<UserJPA> resource = EntityModel.of(user.get());
        Link link = linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users");
        resource.add(link);
        link = linkTo(methodOn(this.getClass()).retrieveUser(2)).withRel("user-2");
        resource.add(link);
        return resource;
    }

    /**
     * GET /users/{id}. This method retrieve a specific user
     */
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * POST /users/{id}. This method create a user
     * 
     * update 21/12/2020: Enhance the POST to return the correct status code. In
     * this situation, return 201 created instead of 200 OK.
     */
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserJPA user) {
        UserJPA newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
