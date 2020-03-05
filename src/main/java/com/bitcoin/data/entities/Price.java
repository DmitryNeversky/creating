package com.bitcoin.data.entities;

import javax.persistence.*;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double incomePrice;
    private double speedPrice;
    private double coolerPrice;
    private double chargePrice;

    @OneToOne(mappedBy="price")
    private Users users;

    public Price(){

    }

    public Price(double incomePrice, double speedPrice, double coolerPrice, double chargePrice) {
        this.incomePrice = incomePrice;
        this.speedPrice = speedPrice;
        this.coolerPrice = coolerPrice;
        this.chargePrice = chargePrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getIncomePrice() {
        return incomePrice;
    }

    public void setIncomePrice(double incomePrice) {
        this.incomePrice = incomePrice;
    }

    public double getSpeedPrice() {
        return speedPrice;
    }

    public void setSpeedPrice(double speedPrice) {
        this.speedPrice = speedPrice;
    }

    public double getCoolerPrice() {
        return coolerPrice;
    }

    public void setCoolerPrice(double coolerPrice) {
        this.coolerPrice = coolerPrice;
    }

    public double getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(double chargePrice) {
        this.chargePrice = chargePrice;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
