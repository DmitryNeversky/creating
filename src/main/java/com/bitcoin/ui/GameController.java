package com.bitcoin.ui;

import com.bitcoin.domain.Game;
import com.bitcoin.domain.LowPrinter;
import com.bitcoin.domain.Tactic;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameController {

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
    private Label lblCharge;

    @FXML
    private Label lblTotal;

    @FXML
    private Button btnCharge;

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
        Tactic tactic = new Tactic(new LowPrinter());

        Game game = new Game(tactic);
        game.farm();
        game.upgrades(lblTotal, btnIncome, btnSpeed, btnCooler, btnCharge);
        game.run();

        btnIncome.setOnAction(e -> {
            game.initIncome(lblIncome);
        });

        btnSpeed.setOnAction(e -> {
            game.initSpeed(lblSpeed);
        });

        btnCooler.setOnAction(e -> {
            game.initCool(lblCool);
        });

        btnCharge.setOnAction(e -> {
            game.initCharge(lblCharge);
        });
    }
}