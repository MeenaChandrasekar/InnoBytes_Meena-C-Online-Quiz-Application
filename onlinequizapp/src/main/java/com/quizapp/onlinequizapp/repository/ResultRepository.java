package com.quizapp.onlinequizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapp.onlinequizapp.model.Result;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByUserId(Long userId);
    List<Result> findByQuizId(Long quizId);
}
