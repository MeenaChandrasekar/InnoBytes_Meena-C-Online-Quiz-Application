package com.quizapp.controller;



import com.quizapp.service.QuizService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class QuizController {

    @FXML
    private VBox quizBox;
    @FXML
    private Button submitButton;

    private QuizService quizService;

    @FXML
    private void initialize() {
        quizService = new QuizService();
        submitButton.setOnAction(event -> handleSubmit());
        loadQuiz();
    }

    private void loadQuiz() {
        // Example Quiz loading logic
        quizService.getQuiz().thenAccept(quiz -> {
            // Load questions into the view
            System.out.println("Quiz loaded");
        });
    }

    private void handleSubmit() {
        // Handle quiz submission and score calculation
        System.out.println("Quiz submitted!");
    }
}
