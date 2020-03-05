package com.bitcoin.domain;

public class Tactic{

    private UpgradeStrategy upgradeStrategy;

    public Tactic(UpgradeStrategy strategy) {
        this.upgradeStrategy = strategy;
    }

    public double upgradeIncome(double income){
        return upgradeStrategy.upgradeIncome(income);
    }

    public int upgradeSpeed(int speed){
        return upgradeStrategy.upgradeSpeed(speed);
    }

    public int upgradeCooler(int cooler){
        return upgradeStrategy.upgradeCooler(cooler);
    }

    public int upgradeMemory(int memory){
        return upgradeStrategy.upgradeMemory(memory);
    }

    public double incomePrice(double price){
        return upgradeStrategy.incomePrice(price);
    }

    public double speedPrice(double price){
        return upgradeStrategy.speedPrice(price);
    }
}