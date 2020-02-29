package com.bitcoin.ui;

import com.bitcoin.domain.Authorize;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegController extends Controller{

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

            // Проверка email на валидность

//            if(validEmail(email)){
//                emailLabel.setText("");
//            } else {
//                emailLabel.setText("Неверный формат email");
//                return;
//            }

            // Проверка пароля на валидность

//            if(!validPassword(password)){
//                passwordLabel.setText("Пароль содержит запрещенные символы");
//                return;
//            } else {
//                passwordLabel.setText("");
//                System.out.println(validPassword(password));
//            }

            // Проверка на содержание пользователя в БД

//            if(new Authorize(email, password).registry()){
//                regButton.getScene().getWindow().hide();
//                repaint("/fxml/auth.fxml", "Авторизация");
//            } else {
//                emailLabel.setText("Указанный email уже используется!");
//            }

            regButton.getScene().getWindow().hide();
            repaint("/fxml/auth.fxml", "Авторизация");
        });
    }
}
