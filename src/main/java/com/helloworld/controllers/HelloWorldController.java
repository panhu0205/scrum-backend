package com.helloworld.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import com.helloworld.beans.*;

/**
 * @Controller: identify this class is the controller
 * @RequestMapping: handles request for a path. In this example is the root path
 * 
 */

// @Controller
@RestController
public class HelloWorldController {

    @Autowired
    public MessageSource messageSource;

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

    @GetMapping(value = "/hello-world-international")
    public String helloWorldInternational(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
        // return "Good Morning";
    }
}
