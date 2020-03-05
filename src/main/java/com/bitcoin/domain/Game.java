package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Price;
import com.bitcoin.data.entities.Printer;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Game {

    public static String email = "a@mail.ru";

    private volatile double money;
    private double income;
    private int speed;

    private double incomePrice;
    private double speedPrice;
    double coolPrice;
    double chargePrice;

    private Tactic tactic;

    public Game(Tactic tactic){
        this.tactic = tactic;
        Printer printer = Crud.getPrinter(email);
        money = printer.getUsers().getMoney();
        income = printer.getIncome();
        speed = printer.getSpeed();

        Price price = Crud.getPrice(email);
        incomePrice = price.getIncomePrice();
        speedPrice = price.getSpeedPrice();
    }

    // <Income, Speed>
    public void farm(){
        System.out.println(incomePrice + " " + speedPrice);
        new Thread(() -> {
            while (true){
                setMoney(getMoney() + income);
                try {
                    Thread.currentThread().join(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // <Buttons>
    public void upgrades(Label total, Button btnIncome, Button btnSpeed){
        new Thread(() -> {
            while (true){
                if(getMoney() < incomePrice){
                    btnIncome.setDisable(true);
                } else {
                    btnIncome.setDisable(false);
                }

                if(getMoney() < speedPrice){
                    btnSpeed.setDisable(true);
                } else {
                    btnSpeed.setDisable(false);
                }

                // Recreate
                Platform.runLater(() -> total.setText(String.format("%.2f", money)));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void initIncome(Label lblIncome){
        setMoney(money - incomePrice);
        income = tactic.upgradeIncome(income);
        lblIncome.setText(String.format("%.2f", income));
        incomePrice = tactic.upIncomePrice(incomePrice);
        System.out.println(incomePrice);
    }

    public synchronized double getMoney() {
        return money;
    }

    public synchronized void setMoney(double money) {
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

    public double getIncomePrice() {
        return incomePrice;
    }

    public double getSpeedPrice() {
        return speedPrice;
    }
}