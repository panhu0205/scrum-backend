package com.user_jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.user_jpa.beans.UserJPA;

import org.springframework.stereotype.Component;

@Component
public class UserJPADAOService {
    private static List<UserJPA> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new UserJPA(1, "John", new Date()));
        users.add(new UserJPA(2, "Bob", new Date()));
        users.add(new UserJPA(3, "Alice", new Date()));
    }

    public List<UserJPA> findAll() {
        return users;
    }

    public UserJPA save(UserJPA user) {
        if (user.getId() == 0) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public UserJPA findOne(int id) {
        for (UserJPA user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public UserJPA deleteByID(int id) {
        Iterator<UserJPA> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            UserJPA user = userIterator.next();
            if (user.getId() == id) {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
