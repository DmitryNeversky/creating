package com.bitcoin.domain;

public class LowPrinter implements UpgradeStrategy{

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

    @Override
    public double incomePrice(double price) {
        return price * 1.25;
    }

    @Override
    public double speedPrice(double price) {
        return price * 1.4;
    }
}
