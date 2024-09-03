package com.quizapp.onlinequizapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.onlinequizapp.model.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuizId(Long quizId);
}
