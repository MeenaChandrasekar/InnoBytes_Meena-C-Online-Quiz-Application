package com.quizapp.service;


import java.util.concurrent.CompletableFuture;

import com.quizapp.model.Quiz;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class QuizService {

    public CompletableFuture<Quiz> getQuiz() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL("http://localhost:8080/api/quiz");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Parse JSON response into Quiz object
                // This is simplified; use a JSON library to parse in real code
                Quiz quiz = new Quiz();
                // Add parsed questions to quiz
                return quiz;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}
