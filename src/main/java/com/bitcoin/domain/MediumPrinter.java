package com.bitcoin.domain;

public class MediumPrinter implements UpgradeStrategy{

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
    public int upgradeMemory(int charge) {
        return charge + 300;
    }

    @Override
    public double incomePrice(double price) {
        return price * 1.4;
    }

    @Override
    public double speedPrice(double price) {
        return price * 1.5;
    }
}
