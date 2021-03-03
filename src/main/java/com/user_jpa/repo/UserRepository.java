package com.user_jpa.repo;

import com.user_jpa.beans.UserJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJPA, Integer> {

}
