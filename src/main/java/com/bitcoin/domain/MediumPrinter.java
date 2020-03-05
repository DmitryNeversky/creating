package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Price;

public class MediumPrinter implements UpgradeStrategy{

    private double incomePrice;
    private double speedPrice;
    private double coolPrice;
    private double chargePrice;

    public MediumPrinter(){
        Price price = Crud.getPrice(Game.email);
        this.incomePrice = price.getIncomePrice();
        this.speedPrice = price.getSpeedPrice();
        this.coolPrice = price.getCoolerPrice();
        this.chargePrice = price.getChargePrice();
    }

    @Override
    public double upgradeIncome(double income) {
        return income * 1.5;
    }

    @Override
    public int upgradeSpeed(int speed) {
        return speed - 40;
    }

    @Override
    public int upgradeCooler(int cooler) {
        return cooler + 4 ;
    }

    @Override
    public int upgradeMemory(int charge) {
        return charge + 200;
    }

    @Override
    public void upgradeIncomePrice() {
        this.incomePrice *= 1.6;
    }

    @Override
    public void upgradeSpeedPrice() {
        this.speedPrice *= 1.9;
    }

    @Override
    public void upgradeCoolPrice() {
        this.coolPrice *= 1.5;
    }

    @Override
    public void upgradeChargePrice() {
        this.chargePrice *= 1.2;
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
