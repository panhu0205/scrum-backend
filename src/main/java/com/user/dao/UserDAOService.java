package com.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.user.beans.User;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "John", new Date()));
        users.add(new User(2, "Bob", new Date()));
        users.add(new User(3, "Alice", new Date()));
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
