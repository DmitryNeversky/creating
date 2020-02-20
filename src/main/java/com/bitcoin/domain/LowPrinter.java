package com.bitcoin.domain;

public class LowPrinter implements Strategy {

    @Override
    public double upgradeIncome(double income) {
        return income * 1.25;
    }

    @Override
    public int upgradeSpeed(int speed) {
        return speed - 20;
    }

    @Override
    public int upgradeCooler(int cooler) {
        return cooler + 2 ;
    }

    @Override
    public int upgradeMemory(int memory) {
        return memory + 100;
    }
}
