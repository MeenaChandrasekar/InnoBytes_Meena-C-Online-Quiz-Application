package com.quizapp.onlinequizapp.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.onlinequizapp.model.Option;

import java.util.List;

public interface OptionService extends JpaRepository<Option, Long> {
    List<Option> findByQuestionId(Long questionId);
}
