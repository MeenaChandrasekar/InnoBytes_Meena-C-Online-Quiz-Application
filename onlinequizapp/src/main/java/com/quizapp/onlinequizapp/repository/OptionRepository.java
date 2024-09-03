package com.quizapp.onlinequizapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quizapp.onlinequizapp.model.Option;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
	@Query("SELECT o FROM Option o WHERE o.question.id = :questionId")
	List<Option> findByQuestionId(@Param("questionId") Long questionId);

}
