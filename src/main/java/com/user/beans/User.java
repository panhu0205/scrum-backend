package com.user.beans;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "amen")
public class User {

    private Integer id;

    @Size(min = 2, message = "your name must have 2 characters")
    @ApiModelProperty(notes = "2 characters plz")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birth date should be in past")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

    private List<Post> posts;

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public List<Post> getPosts() {
        return posts;
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

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }
}
