package com.bitcoin.ui;

import com.bitcoin.domain.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RemController extends Validator{

    @FXML
    private Button remButton;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label emailLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    void initialize() {
        remButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if(validEmail(email, emailLabel) && validPassword(password, passwordLabel)) {
                Controller controller = new Controller(email, password);

                if (controller.auth(emailLabel, passwordLabel)) {
                    controller.removeAccount();
                    remButton.getScene().getWindow().hide();
                    repaint("/fxml/auth.fxml", "Авторизация");
                }
            }
        });
    }
}
