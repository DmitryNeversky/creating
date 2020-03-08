package com.bitcoin.domain;

public class Tactic{

    private UpgradeStrategy upgradeStrategy;

    public Tactic(UpgradeStrategy strategy) {
        this.upgradeStrategy = strategy;
    }

    double upgradeIncome(double income){
        return upgradeStrategy.upgradeIncome(income);
    }

    int upgradeSpeed(int speed){
        return upgradeStrategy.upgradeSpeed(speed);
    }

    int upgradeCooler(int cooler){
        return upgradeStrategy.upgradeCooler(cooler);
    }

    int upgradeCharge(int charge){
        return upgradeStrategy.upgradeCharge(charge);
    }

    double upIncomePrice(double incomePrice){
        return upgradeStrategy.upIncomePrice(incomePrice);
    }

    double upSpeedPrice(double speedPrice){
        return upgradeStrategy.upSpeedPrice(speedPrice);
    }

    double upCoolPrice(double coolPrice){
        return upgradeStrategy.upCoolPrice(coolPrice);
    }

    double upChargePrice(double chargePrice){
        return upgradeStrategy.upChargePrice(chargePrice);
    }

    int upFlame(int fire){
        return upgradeStrategy.upFire(fire);
    }

    int upCool(int cool){
        return upgradeStrategy.upCool(cool);
    }
}