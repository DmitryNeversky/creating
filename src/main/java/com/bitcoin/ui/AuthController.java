package com.bitcoin.ui;

import com.bitcoin.domain.Authorize;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;

public class AuthController extends Controller{

    @FXML
    private URL location;

    @FXML
    private TextField authEmail;

    @FXML
    private Button authButton;

    @FXML
    private Button regButton;

    @FXML
    private PasswordField authPassword;

    @FXML
    private Label emailLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    void initialize() {
        authButton.setOnAction(e -> {
            String email = authEmail.getText();
            String password = authPassword.getText();

            if(validEmail(email, emailLabel) && validPassword(password, passwordLabel)) {
                if (new Authorize(email, password).auth()) {
                    authButton.getScene().getWindow().hide();
                    repaint("/fxml/bitcoin.fxml", "Игра");
                } else {
                    emailLabel.setText("Аккаунт не найден");
                }
            }
        });

        regButton.setOnAction(e -> {
            regButton.getScene().getWindow().hide();
            repaint("/fxml/reg.fxml", "Регистрация");
        });
    }
}