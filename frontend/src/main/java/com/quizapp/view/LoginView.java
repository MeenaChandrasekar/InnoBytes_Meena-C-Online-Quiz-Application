package com.quizapp.view;



import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class LoginView {

    private VBox root;

    public LoginView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quizapp/front/views/login.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VBox getRoot() {
        return root;
    }
}
