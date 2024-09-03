package com.quizapp.onlinequizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.onlinequizapp.model.Quiz;
import com.quizapp.onlinequizapp.repository.QuizRepository;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz findById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
