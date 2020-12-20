package com.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.beans.*;

/**
 * @Controller: identify this class is the controller
 * @RequestMapping: handles request for a path. In this example is the root path
 * 
 */

// @Controller
@RestController
public class HelloWorldController {
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping(value = "/")
    public String helloWorld() {
        // return "Hello World Restcontroller";
        return "<h1>Hello World</h1>";
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World, I'm Bean");
    }

    @GetMapping(value = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s, Nice to meet you", name));
    }
}
