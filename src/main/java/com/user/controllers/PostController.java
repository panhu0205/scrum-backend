package com.user.controllers;

import java.net.URI;
import java.util.List;

import com.user.beans.Post;
import com.user.dao.PostDAOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PostController {

    @Autowired
    private PostDAOService service;

    /**
     * GET /users. This method retrieve all users and return a json
     */
    @GetMapping("/posts")
    public List<Post> retrieveAllUsers() {
        return service.findAll();
    }

    /**
     * GET /users/{id}. This method retrieve a specific user
     */
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostFromUser(@PathVariable Integer id) {
        return service.findAllFromUser(id);
    }

    /**
     * GET /users/{id}. This method retrieve a specific user
     */
    @GetMapping("/users/{id}/posts/{post_id}")
    public Post retrievePostFromUser(@PathVariable Integer id, @PathVariable Integer post_id) {
        return service.findOneFromUser(id, post_id);
    }

    /**
     * POST /users/{id}. This method create a user
     * 
     * update 21/12/2020: Enhance the POST to return the correct status code. In
     * this situation, return 201 created instead of 200 OK.
     */
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createUser(@RequestBody Post post, @PathVariable Integer id) {
        post.setAuthor(id);
        Post newPost = service.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/users/{id}/posts/{post_id}")
                .buildAndExpand(newPost.getAuthor(), newPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
