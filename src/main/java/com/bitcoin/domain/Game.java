package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Price;
import com.bitcoin.data.entities.Printer;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static String email = "a@mail.ru";

    private volatile double money;
    private int lvl;
    private double income;
    private int speed;
    private int cooler;
    private int charge;

    private double incomePrice;
    private double speedPrice;
    private double coolPrice;
    private double chargePrice;

    private List<Thread> list = new ArrayList<>();
    private static boolean stop = true;

    private Tactic tactic;

    public Game(Tactic tactic){
        this.tactic = tactic;

        Printer printer = Crud.getPrinter(email);
        money = printer.getUsers().getMoney();
        income = printer.getIncome();
        speed = printer.getSpeed();
        cooler = printer.getCooler();
        charge = printer.getCharge();

        Price price = Crud.getPrice(email);
        incomePrice = price.getIncomePrice();
        speedPrice = price.getSpeedPrice();
        coolPrice = price.getCoolerPrice();
        chargePrice = price.getChargePrice();
    }

    public Game() {

    }

    // <Income, Speed>
    public void farm(){
        Thread thread = new Thread(() -> {
            while (stop){
                setMoney(getMoney() + income);
                try {
                    Thread.currentThread().join(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        list.add(thread);
    }

    // <Buttons>
    public void upgrades(Label total, Button btnIncome, Button btnSpeed, Button btnCool, Button btnCharge){
        Thread  thread = new Thread(() -> {
            while (stop){

                if(getMoney() < incomePrice) btnIncome.setDisable(true);
                else btnIncome.setDisable(false);

                if(getMoney() < speedPrice) btnSpeed.setDisable(true);
                else btnSpeed.setDisable(false);

                if(getMoney() < coolPrice) btnCool.setDisable(true);
                else btnCool.setDisable(false);

                if(getMoney() < chargePrice) btnCharge.setDisable(true);
                else btnCharge.setDisable(false);

                // Recreate + Flame + Voltage
                Platform.runLater(() -> total.setText(String.format("%.2f", money)));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        list.add(thread);
    }

    public void run(){
        for(Thread pair : list){
            pair.start();
        }
    }

    public void stop(){
        stop = false;
        for(Thread pair : list){
            try {
                pair.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saveUser();
    }

    private void saveUser(){
        Printer printer = new Printer(lvl, income, speed, cooler, charge);
        Price price = new Price(incomePrice, speedPrice, coolPrice, chargePrice);
        Crud.saveUser(email, money, printer, price);
    }

    public void initIncome(Label lblIncome){
        setMoney(money - incomePrice);
        income = tactic.upgradeIncome(income);
        lblIncome.setText("Добыча: " + String.format("%.2f", income));
        incomePrice = tactic.upIncomePrice(incomePrice);
    }

    public void initSpeed(Label lblSpeed){
        setMoney(money - speedPrice);
        speed = tactic.upgradeSpeed(speed);
        lblSpeed.setText("Задержка: "+ speed / 1000 + "," + speed % 1000 / 10 + " сек.");
        speedPrice = tactic.upSpeedPrice(speedPrice);
    }

    public void initCool(Label lblCool){
        setMoney(money - coolPrice);
        cooler = tactic.upgradeCooler(cooler);
        lblCool.setText("Охлаждение: " + cooler + " C");
        coolPrice = tactic.upCoolPrice(coolPrice);
    }

    public void initCharge(Label lblCharge){
        setMoney(money - chargePrice);
        charge = tactic.upgradeCharge(charge);
        lblCharge.setText("Заряд: " + charge + " Вт");
        chargePrice = tactic.upChargePrice(chargePrice);
    }

    private synchronized double getMoney() {
        return money;
    }

    private synchronized void setMoney(double money) {
        this.money = money;
    }
}