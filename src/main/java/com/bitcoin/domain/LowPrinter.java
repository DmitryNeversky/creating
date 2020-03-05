package com.bitcoin.domain;

public class LowPrinter implements UpgradeStrategy{

    @Override
    public synchronized double upgradeIncome(double income) {
        return income * 1.25;
    }

    @Override
    public synchronized int upgradeSpeed(int speed) {
        return speed - 20;
    }

    @Override
    public synchronized int upgradeCooler(int cooler) {
        return cooler + 2 ;
    }

    @Override
    public synchronized int upgradeCharge(int charge) {
        return charge + 100;
    }

    @Override
    public double upIncomePrice(double incomePrice) {
        return incomePrice *= 1.2;
    }

    @Override
    public double upSpeedPrice(double speedPrice) {
        return speedPrice *= 1.4;
    }
}
