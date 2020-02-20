package com.bitcoin.domain;

public class MediumPrinter implements Strategy{

    @Override
    public double upgradeIncome(double income) {
        return income * 2;
    }

    @Override
    public int upgradeSpeed(int speed) {
        return speed - 40;
    }

    @Override
    public int upgradeCooler(int cooler) {
        return cooler + 3 ;
    }

    @Override
    public int upgradeMemory(int memory) {
        return memory + 300;
    }
}
