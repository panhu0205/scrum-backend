package com.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller: identify this class is the controller
 * @RequestMapping: handles request for a path. In this example is the root path
 * 
 */

@Controller
// @RestController
public class HelloWorldController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        // return "Hello World Restcontroller";
        return "hello";
    }
}
