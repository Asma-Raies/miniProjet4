package com.asma.makeUp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asma.makeUp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
        User findByUsername (String username);
}
