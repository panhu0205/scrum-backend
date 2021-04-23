package com.repo;

import com.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findAccountByUsername(String username);

    public User findById(Long id);
}
