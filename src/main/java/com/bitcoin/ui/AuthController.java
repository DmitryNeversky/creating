package com.bitcoin.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthController extends Controller{

    @FXML
    private ResourceBundle resources;

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
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    public void setLblEmail(String email) {
        this.lblPassword.setText(email);
    }

    public void setLblPassword(String password) {
        this.lblPassword.setText(password);
    }

    @FXML
    void initialize() {
        String email = authEmail.getText();
        String password = authPassword.getText();
        authButton.setOnAction(e -> {

            // if
            authButton.getScene().getWindow().hide();
            repaint("/fxml/bitcoin.fxml", "Bitcoin");
        });

        regButton.setOnAction(e -> {
            regButton.getScene().getWindow().hide();
            repaint("/fxml/reg.fxml", "Регистрация");
        });
    }
}