package com.bitcoin.domain;

public class Tactic{

    private Strategy strategy;

    public Tactic(Strategy strategy) {
        this.strategy = strategy;
    }

    public double upgradeIncome(double income){
        return strategy.upgradeIncome(income);
    }

    public int upgradeSpeed(int speed){
        return strategy.upgradeSpeed(speed);
    }

    public int upgradeCooler(int cooler){
        cooler = strategy.upgradeCooler(cooler);
        return cooler;
    }

    public int upgradeMemory(int memory){
        return strategy.upgradeMemory(memory);
    }
}
