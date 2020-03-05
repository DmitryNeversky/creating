package com.bitcoin.domain;

public class HighPrinter implements UpgradeStrategy{

    @Override
    public double upgradeIncome(double income) {
        return income * 2;
    }

    @Override
    public int upgradeSpeed(int speed) {
        return speed - 60;
    }

    @Override
    public int upgradeCooler(int cooler) {
        return cooler + 6 ;
    }

    @Override
    public int upgradeCharge(int charge) {
        return charge + 300;
    }

    @Override
    public double upIncomePrice(double incomePrice) {
        return 0;
    }

    @Override
    public double upSpeedPrice(double speedPrice) {
        return 0;
    }

    @Override
    public double upCoolPrice(double coolPrice) {
        return 0;
    }

    @Override
    public double upChargePrice(double chargePrice) {
        return 0;
    }
}
