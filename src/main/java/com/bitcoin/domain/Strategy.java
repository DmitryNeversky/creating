package com.bitcoin.domain;

public interface Strategy {
    double upgradeIncome(double income);
    int upgradeSpeed(int speed);
    int upgradeCooler(int cooler);
    int upgradeMemory(int memory);
}
