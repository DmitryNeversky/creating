package com.bitcoin.ui;

import com.bitcoin.domain.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegController extends Validator {

    @FXML
    private PasswordField regPassword;

    @FXML
    private TextField regEmail;

    @FXML
    private Label emailLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button regButton;

    @FXML
    void initialize() {
        regButton.setOnAction(e -> {
            String email = regEmail.getText();
            String password = regPassword.getText();

            if(validEmail(email, emailLabel) && validPassword(password, passwordLabel)) {
                if(new Controller(email, password).registry(emailLabel)) {
                    regButton.getScene().getWindow().hide();
                    repaint("/fxml/auth.fxml", "Авторизация");
                }
            }
        });
    }
}