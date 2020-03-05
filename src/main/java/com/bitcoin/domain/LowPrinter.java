package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Price;

public class LowPrinter implements UpgradeStrategy{

    private double incomePrice;
    private double speedPrice;
    private double coolPrice;
    private double chargePrice;

    public LowPrinter(){
        Price price = Crud.getPrice(Game.email);
        this.incomePrice = price.getIncomePrice();
        this.speedPrice = price.getSpeedPrice();
        this.coolPrice = price.getCoolerPrice();
        this.chargePrice = price.getChargePrice();
    }

    @Override
    public double upgradeIncome(double income) {
        return income * 1.25;
    }

    @Override
    public int upgradeSpeed(int speed) {
        return speed - 20;
    }

    @Override
    public int upgradeCooler(int cooler) {
        return cooler + 2 ;
    }

    @Override
    public int upgradeMemory(int charge) {
        return charge + 100;
    }

    @Override
    public double incomePrice(double price) {
        return price * 1.25;
    }

    @Override
    public double speedPrice(double price) {
        return price * 1.4;
    }

    public double getIncomePrice() {
        return incomePrice;
    }

    public double getSpeedPrice() {
        return speedPrice;
    }

    public double getCoolPrice() {
        return coolPrice;
    }

    public double getChargePrice() {
        return chargePrice;
    }
}
