package com.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.user.beans.Post;
import com.user.beans.User;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static List<Post> posts = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "John", new Date()));
        users.add(new User(2, "Bob", new Date()));
        users.add(new User(3, "Alice", new Date()));

        posts.add(new Post(1, "I love Alice", 1));
        posts.add(new Post(2, "I love Alice a lot", 1));
        posts.add(new Post(3, "I love Bob", 2));
        posts.add(new Post(4, "I love John", 3));

        for (User user : users) {
            List<Post> userPosts = new ArrayList<Post>();
            for (Post post : posts) {
                if (post.getAuthor() == user.getId()) {
                    userPosts.add(post);
                }
            }
            user.setPosts(userPosts);
        }
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
