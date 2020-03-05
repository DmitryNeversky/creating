package com.bitcoin.ui;

import com.bitcoin.domain.Game;
import com.bitcoin.domain.LowPrinter;
import com.bitcoin.domain.Tactic;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    private Label lblMemory;

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

        Game game = new Game();
        game.farm();
        game.upgrades(btnIncome, btnSpeed);

        lblTotal.setText(String.format("%.2f", game.getMoney()));
        lblIncome.setText("Добыча " + String.format("%.2f", game.getIncome()));
        lblSpeed.setText("Задержка " + game.getSpeed() + "/мс");

        btnIncome.setOnAction(e -> {
            lblTotal.setText(String.valueOf(game.getMoney()));
            game.setMoney(game.getMoney() - 50);
            game.setIncome(tactic.upgradeIncome(game.getIncome()));
            lblIncome.setText("Добыча " + String.format("%.2f", game.getIncome()));
        });

        btnSpeed.setOnAction(e -> {
            game.setSpeed(tactic.upgradeSpeed(game.getSpeed()));
            lblSpeed.setText("Задержка " + game.getSpeed() + "/мс");
        });
    }
}