package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Price;

public class LowPrinter extends Game implements UpgradeStrategy{

    public LowPrinter(){
        Price price = Crud.getPrice(Game.email);
        incomePrice = price.getIncomePrice();
        speedPrice = price.getSpeedPrice();
        coolPrice = price.getCoolerPrice();
        chargePrice = price.getChargePrice();
    }

    @Override
    public synchronized double upgradeIncome(double income) {
        incomePrice *= 1.2;
        return income * 1.25;
    }

    @Override
    public synchronized int upgradeSpeed(int speed) {
        this.speedPrice *= 1.4;
        return speed - 20;
    }

    @Override
    public synchronized int upgradeCooler(int cooler) {
        this.coolPrice *= 1.3;
        return cooler + 2 ;
    }

    @Override
    public synchronized int upgradeCharge(int charge) {
        this.chargePrice *= 1.2;
        return charge + 100;
    }
}
