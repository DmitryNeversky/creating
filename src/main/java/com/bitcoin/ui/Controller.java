package com.bitcoin.ui;

import java.net.URL;
import java.util.ResourceBundle;

import com.bitcoin.domain.Authorize;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblSpeed;

    @FXML
    private ImageView img;

    @FXML
    private Label lblFlame;

    @FXML
    private Button btnPrinter;

    @FXML
    private Button btnSpeed;

    @FXML
    private Label lblMemory;

    @FXML
    private Label lblTotal;

    @FXML
    private Button btnMemory;

    @FXML
    private Label lblCool;

    @FXML
    private Button btnIncome;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblIncome;

    @FXML
    private Button btnCooler;

    @FXML
    void initialize() {
        btnCooler.setOnAction(e -> {
            new Authorize("mit@mail.ru", "Myp3ik").removeAccount();
        });
    }
}