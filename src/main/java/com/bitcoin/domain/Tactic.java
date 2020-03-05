package com.bitcoin.domain;

public class Tactic{

    private UpgradeStrategy upgradeStrategy;

    Tactic(){}

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
        return upgradeStrategy.upIncomePrice(speedPrice);
    }
}