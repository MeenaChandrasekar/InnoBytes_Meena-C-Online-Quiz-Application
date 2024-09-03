package com.quizapp.onlinequizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizapp.onlinequizapp.model.Result;
import com.quizapp.onlinequizapp.repository.ResultRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public Result save(Result result) {
        return resultRepository.save(result);
    }

    public Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    public List<Result> findByUserId(Long userId) {
        return resultRepository.findByUserId(userId);
    }

    public List<Result> findByQuizId(Long quizId) {
        return resultRepository.findByQuizId(quizId);
    }

    public void deleteById(Long id) {
        resultRepository.deleteById(id);
    }
}
