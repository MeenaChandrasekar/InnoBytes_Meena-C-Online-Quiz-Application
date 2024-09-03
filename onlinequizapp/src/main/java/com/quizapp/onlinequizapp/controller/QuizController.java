package com.quizapp.onlinequizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quizapp.onlinequizapp.model.Quiz;
import com.quizapp.onlinequizapp.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    /**
     * Creates a new quiz.
     * 
     * @param quiz The quiz to be created.
     * @return A ResponseEntity with the created quiz and HTTP status 201 Created.
     */
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        // Save the quiz and return a response
        Quiz savedQuiz = quizService.save(quiz);
        return new ResponseEntity<>(savedQuiz, HttpStatus.CREATED);
    }

    /**
     * Retrieves a quiz by its ID.
     * 
     * @param id The ID of the quiz to retrieve.
     * @return A ResponseEntity with the quiz and HTTP status 200 OK, or HTTP status 404 Not Found if the quiz does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.findById(id);
        if (quiz != null) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves all quizzes.
     * 
     * @return A ResponseEntity with a list of all quizzes and HTTP status 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.findAll();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    /**
     * Deletes a quiz by its ID.
     * 
     * @param id The ID of the quiz to delete.
     * @return A ResponseEntity with HTTP status 204 No Content if the quiz was deleted, or HTTP status 404 Not Found if the quiz does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        // Check if the quiz exists before trying to delete
        if (quizService.findById(id) != null) {
            quizService.deleteQuiz(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
