package com.quizapp.controller;

import com.quizapp.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginController {

    @FXML
    private VBox loginBox;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private UserService userService;

    @FXML
    private void initialize() {
        userService = new UserService();
        loginButton.setOnAction(event -> handleLogin());
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Call backend service
        userService.login(username, password).thenAccept(success -> {
            if (success) {
                // Load next view
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        });
    }
}
