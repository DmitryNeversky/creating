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
    private int cooler;
    private int charge;

    private double incomePrice;
    private double speedPrice;
    private double coolPrice;
    private double chargePrice;

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

    // <Income, Speed>
    public void farm(){
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
    public void upgrades(Label total, Button btnIncome, Button btnSpeed, Button btnCool, Button btnCharge){
        new Thread(() -> {
            while (true){

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
        }).start();
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