package com.quizapp.onlinequizapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.onlinequizapp.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

