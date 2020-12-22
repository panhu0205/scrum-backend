package com.user.beans;

public class Post {
    private Integer id;
    private String content;
    private Integer authorID;

    public Post(Integer id, String content, Integer authorID) {
        this.id = id;
        this.content = content;
        this.authorID = authorID;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getAuthor() {
        return authorID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(Integer authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Post [id=%s, content=%s, author=%s]", id, content, authorID);
    }
}