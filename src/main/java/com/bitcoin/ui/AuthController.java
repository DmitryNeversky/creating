package com.bitcoin.ui;

import java.net.URL;
import java.util.ResourceBundle;

import com.bitcoin.data.database.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField authEmail;

    @FXML
    private Button authButton;

    @FXML
    private PasswordField authPassword;

    @FXML
    void initialize() {

        String email = authEmail.getText().trim();
        String password = authPassword.getText().trim();

        authButton.setOnAction(e -> {

        });
    }
}
