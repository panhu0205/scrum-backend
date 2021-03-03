package com.user.dao;

import java.util.ArrayList;
import java.util.List;

import com.user.beans.Post;
import com.user.beans.User;

import org.springframework.stereotype.Component;

@Component
public class PostDAOService {
    private static List<Post> posts = new ArrayList<>();

    private static int postsCount = 4;

    static {
        posts.add(new Post(1, "I love Alice", 1));
        posts.add(new Post(2, "I love Alice a lot", 1));
        posts.add(new Post(3, "I love Bob", 2));
        posts.add(new Post(4, "I love John", 3));
    }

    public List<Post> findAll() {
        return posts;
    }

    public List<Post> findAllFromUser(int userID) {
        List<Post> userPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAuthor() == userID) {
                userPosts.add(post);
            }
        }
        return userPosts;
    }

    public Post findOneFromUser(int userID, int postID) {
        for (Post post : posts) {
            if (post.getAuthor() == userID && post.getId() == postID) {
                return post;
            }
        }
        return null;
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(++postsCount);
        }
        posts.add(post);
        return post;
    }

}
