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

    @Override
    public double upCoolPrice(double coolPrice) {
        return coolPrice *= 1.7;
    }

    @Override
    public double upChargePrice(double chargePrice) {
        return chargePrice *= 1.1;
    }

    @Override
    public int upFire(int flame) {
        return flame + 4;
    }

    @Override
    public int upCool(int cool) {
        return cool + 6;
    }
}
