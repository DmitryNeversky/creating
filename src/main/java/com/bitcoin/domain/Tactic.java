package com.bitcoin.domain;

class Tactic{
    private Strategy strategy;

    Tactic(Strategy strategy) {
        this.strategy = strategy;
    }

    double upgradeIncome(double income){
        return strategy.upgradeIncome(income);
    }

    int upgradeSpeed(int speed){
        speed = strategy.upgradeSpeed(speed);
        return speed;
    }

    int upgradeCooler(int cooler){
        cooler = strategy.upgradeSpeed(cooler);
        return cooler;
    }

    int upgradeMemory(int memory){
        memory = strategy.upgradeSpeed(memory);
        return memory;
    }
}
