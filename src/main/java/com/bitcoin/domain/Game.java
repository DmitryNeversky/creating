package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Printer;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Game {

    public static String email;
    Tactic tactic;

    private double money;
    private double income;
    private int speed;

    public Game(){
        Printer printer = Crud.getPrinter(email);
        money = printer.getUsers().getMoney();
        income = printer.getIncome();
        speed = printer.getSpeed();
    }

    public void farm(Label totalLabel){
        new Thread(() -> {
            while (true){
                money += income;
                Platform.runLater(() -> totalLabel.setText(String.format("%.2f", money)) );
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Разработка

    public void upgrades(Button btnIncome, Button btnSpeed){
        new Thread(() -> Platform.runLater(() -> {

//            if(money < incomePrice){
//                btnIncome.setDisable(true);
//            } else {
//                btnIncome.setDisable(false);
//            }
//
//            if(money < speedPrice){
//                btnSpeed.setDisable(true);
//            } else {
//                btnSpeed.setDisable(false);
//            }

        })).start();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
