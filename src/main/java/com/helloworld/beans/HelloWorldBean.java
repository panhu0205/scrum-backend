package com.helloworld.beans;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean() {

    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
