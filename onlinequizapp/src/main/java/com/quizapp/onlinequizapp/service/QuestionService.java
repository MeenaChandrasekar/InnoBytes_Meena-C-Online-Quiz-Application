package com.quizapp.onlinequizapp.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapp.onlinequizapp.model.Question;
import com.quizapp.onlinequizapp.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> findByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
