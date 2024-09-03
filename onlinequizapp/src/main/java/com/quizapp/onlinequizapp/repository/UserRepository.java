package com.quizapp.onlinequizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.onlinequizapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
