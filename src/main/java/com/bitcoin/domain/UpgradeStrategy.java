package com.bitcoin.domain;

public interface UpgradeStrategy {
    double upgradeIncome(double income);
    int upgradeSpeed(int speed);
    int upgradeCooler(int cooler);
    int upgradeCharge(int charge);

    double upIncomePrice(double incomePrice);
    double upSpeedPrice(double speedPrice);
    double upCoolPrice(double coolPrice);
    double upChargePrice(double chargePrice);
}
