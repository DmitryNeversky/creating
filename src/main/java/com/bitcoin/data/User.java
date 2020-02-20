package com.bitcoin.data;// Entity

public class User {
    private double money = 100; // В будущем доставать из БД
    private double income = 1; // В будущем доставать из БД
    private int speed = 1000; // В будущем доставать из БД

    public double getMoney() {
        return money;
    }

    public double getIncome() {
        return income;
    }

    public int getSpeed() {
        return speed;
    }
}
