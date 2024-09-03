package com.quizapp.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultController {

    @FXML
    private Label resultLabel;

    public void setResult(String result) {
        resultLabel.setText(result);
    }
}
