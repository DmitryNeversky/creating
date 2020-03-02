package com.bitcoin.ui;

import com.bitcoin.domain.Game;
import com.bitcoin.domain.LowPrinter;
import com.bitcoin.domain.Tactic;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameController {

    public static String email;

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
        Game game = new Game(email);
        Tactic tactic = new Tactic(new LowPrinter());
        game.farm(lblTotal);

        btnPrinter.setOnAction(e -> {

        });

        btnIncome.setOnAction(e -> {
            game.setIncome(tactic.upgradeIncome(game.getIncome()));
        });

        btnSpeed.setOnAction(e -> {
            game.setSpeed(tactic.upgradeSpeed(game.getSpeed()));
        });
    }
}