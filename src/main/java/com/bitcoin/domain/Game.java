package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Printer;
import javafx.scene.control.Button;

public class Game {

    public static String email = "a@mail.ru";

    private double money;
    private double income;
    private int speed;

    double incomePrice;
    double speedPrice;
    double coolPrice;
    double chargePrice;

    public Game(){
        Printer printer = Crud.getPrinter(email);
        money = printer.getUsers().getMoney();
        income = printer.getIncome();
        speed = printer.getSpeed();
    }

    // <Income, Speed>
    public void farm(){
        new Thread(() -> {
            while (true){
                money += income;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // <Buttons>
    public void upgrades(Button btnIncome, Button btnSpeed){
        new Thread(() -> {
            while (true){
                if(money < incomePrice){
                    btnIncome.setDisable(true);
                } else {
                    btnIncome.setDisable(false);
                }

                if(money < speedPrice){
                    btnSpeed.setDisable(true);
                } else {
                    btnSpeed.setDisable(false);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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