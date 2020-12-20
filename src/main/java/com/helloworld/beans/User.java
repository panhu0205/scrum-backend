package com.helloworld.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

public class User {
    private Integer id;
    private String name;
    private Date birthDate;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }
}
