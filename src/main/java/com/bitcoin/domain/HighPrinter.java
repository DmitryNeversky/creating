package com.bitcoin.domain;

public class HighPrinter implements Strategy{

    @Override
    public double upgradeIncome(double income) {
        return income * 3;
    }

    @Override
    public int upgradeSpeed(int speed) {
        return speed - 80;
    }

    @Override
    public int upgradeCooler(int cooler) {
        return cooler + 4 ;
    }

    @Override
    public int upgradeMemory(int memory) {
        return memory + 500;
    }
}
