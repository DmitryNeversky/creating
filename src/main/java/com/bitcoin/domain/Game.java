package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Price;
import com.bitcoin.data.entities.Printer;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static String email = "a@mail.ru";

    private static volatile double money;
    private static int lvl;
    private static double income;
    private static int speed;
    private static int cooler;
    private static int charge;

    private static int lvlIncome;
    private static int lvlSpeed;
    private static int lvlCool;
    private static int lvlCharge;

    private static int flame;
    private static int cool;
    private static int voltage;

    private static double incomePrice;
    private static double speedPrice;
    private static double coolPrice;
    private static double chargePrice;

    private static List<Thread> list = new ArrayList<>();
    private static boolean stop = true;

    private Tactic tactic;

    private static Printer printer;

    private static Price price;

    public Game(Tactic tactic){
        this.tactic = tactic;

        printer = Crud.getPrinter(email);
        money = printer.getUsers().getMoney();
        income = printer.getIncome();
        speed = printer.getSpeed();
        cooler = printer.getCooler();
        charge = printer.getCharge();

        price = Crud.getPrice(email);
        incomePrice = price.getIncomePrice();
        speedPrice = price.getSpeedPrice();
        coolPrice = price.getCoolerPrice();
        chargePrice = price.getChargePrice();
    }

    // <Income, Speed>
    public void farm(){
        Thread thread = new Thread(() -> {
            while (stop){
                setMoney(money + income);
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

                if(money < incomePrice && lvlIncome <= 50) btnIncome.setDisable(true);
                else btnIncome.setDisable(false);

                if(money < speedPrice && lvlSpeed <= 50) btnSpeed.setDisable(true);
                else btnSpeed.setDisable(false);

                if(money < coolPrice && lvlCool <= 50) btnCool.setDisable(true);
                else btnCool.setDisable(false);

                if(money < chargePrice && lvlCharge <= 50) btnCharge.setDisable(true);
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

    public static void stop(){
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

    private static void saveUser(){
        printer.setIncome(income);
        printer.setSpeed(speed);
        printer.setCooler(cooler);
        printer.setCharge(charge);

        price.setIncomePrice(incomePrice);
        price.setSpeedPrice(speedPrice);
        price.setCoolerPrice(coolPrice);
        price.setChargePrice(chargePrice);
        Crud.saveUser(email, money, printer, price);
    }

    public void initIncome(Label lblIncome){
        setMoney(money - incomePrice);
        income = tactic.upgradeIncome(income);
        lblIncome.setText("Добыча: " + String.format("%.2f", income));
        incomePrice = tactic.upIncomePrice(incomePrice);
        flame = tactic.upFlame(flame);
        lvlIncome++;
    }

    public void initSpeed(Label lblSpeed){
        setMoney(money - speedPrice);
        speed = tactic.upgradeSpeed(speed);
        lblSpeed.setText("Задержка: "+ speed / 1000 + "," + speed % 1000 / 10 + " сек.");
        speedPrice = tactic.upSpeedPrice(speedPrice);
        flame = tactic.upFlame(flame);
        lvlSpeed++;
    }

    public void initCool(Label lblCool){
        setMoney(money - coolPrice);
        cooler = tactic.upgradeCooler(cooler);
        lblCool.setText("Охлаждение: " + cooler + " C");
        coolPrice = tactic.upCoolPrice(coolPrice);
        cool = tactic.upCool(cool);
        lvlCool++;
    }

    public void initCharge(Label lblCharge){
        setMoney(money - chargePrice);
        charge = tactic.upgradeCharge(charge);
        lblCharge.setText("Заряд: " + charge + " Вт");
        chargePrice = tactic.upChargePrice(chargePrice);
        lvlCharge++;
    }

    // Thread
    public void initFlame(Label lblFlame){
        int abs = new Random().nextInt(cool - flame);
        lblFlame.setText("Flame: " + abs);
    }

    private synchronized void setMoney(double money) {
        Game.money = money;
    }
}