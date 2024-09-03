package com.quizapp.service;

import com.quizapp.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quizdb"; // Change as per your DB configuration
    private static final String DB_USER = "root"; // Change as per your DB configuration
    private static final String DB_PASSWORD = "Password@1"; 

    // Load the JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver");
        }
    }

    // Add a new question to the database
    public void addQuestion(Question question) {
        String sql = "INSERT INTO questions (text, options, answer) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, question.getText());
            stmt.setString(2, String.join("|", question.getOptions())); // Store options as a pipe-separated string
            stmt.setString(3, question.getAnswer());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add question");
        }
    }

    // Retrieve a question by its ID
    public Question getQuestion(int id) {
        String sql = "SELECT * FROM questions WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String text = rs.getString("text");
                String[] options = rs.getString("options").split("\\|"); // Split options by pipe character
                String answer = rs.getString("answer");
                return new Question(text, options, answer);
            } else {
                throw new RuntimeException("Question not found with ID " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve question");
        }
    }

    // Update an existing question in the database
    public void updateQuestion(int id, Question question) {
        String sql = "UPDATE questions SET text = ?, options = ?, answer = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, question.getText());
            stmt.setString(2, String.join("|", question.getOptions())); // Store options as a pipe-separated string
            stmt.setString(3, question.getAnswer());
            stmt.setInt(4, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update question");
        }
    }

    // Delete a question from the database
    public void deleteQuestion(int id) {
        String sql = "DELETE FROM questions WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete question");
        }
    }

    // Retrieve all questions from the database
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String text = rs.getString("text");
                String[] options = rs.getString("options").split("\\|"); // Split options by pipe character
                String answer = rs.getString("answer");
                questions.add(new Question(text, options, answer));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve questions");
        }
        return questions;
    }
}
