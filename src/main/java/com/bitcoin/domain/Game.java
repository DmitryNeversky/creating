package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Printer;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Game {

    private double money;
    private double income;
    private int speed;

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

    public Game(String email){
        Printer printer = Crud.getPrinter(email);
        money = printer.getUsers().getMoney();
        income = printer.getIncome();
        speed = printer.getSpeed();
    }

    public void farm(Label totalLabel){
        new Thread(() -> {
            while (true){
                money += income;
                Platform.runLater(() -> totalLabel.setText(String.valueOf((long)money)));
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

//    public static void savePrinter(){
//
//    }
}
