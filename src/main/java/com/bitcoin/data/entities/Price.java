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
    private double memoryPrice;

    @OneToOne(mappedBy="price")
    private Users users;

    public Price(){

    }

    public Price(double incomePrice, double speedPrice, double coolerPrice, double memoryPrice) {
        this.incomePrice = incomePrice;
        this.speedPrice = speedPrice;
        this.coolerPrice = coolerPrice;
        this.memoryPrice = memoryPrice;
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

    public double getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryPrice(double memoryPrice) {
        this.memoryPrice = memoryPrice;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
