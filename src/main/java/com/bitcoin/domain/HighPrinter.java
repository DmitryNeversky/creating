package com.bitcoin.domain;

public class HighPrinter implements UpgradeStrategy{

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
    public int upgradeMemory(int charge) {
        return charge + 500;
    }

    @Override
    public double incomePrice(double price) {
        return price * 1.9;
    }

    @Override
    public double speedPrice(double price) {
        return price * 1.1;
    }
}
