package com.bitcoin.data.entities;

import javax.persistence.*;

@Entity
public class Printer {
    @Id
    @GeneratedValue
    private long id;

    private int lvl;
    private double income;
    private int speed;
    private int cooler;
    private int memory;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="printer")
    private Users users;

    public Printer(){}

    public Printer(int lvl, double income, int speed, int cooler, int memory) {
        this.lvl = lvl;
        this.income = income;
        this.speed = speed;
        this.cooler = cooler;
        this.memory = memory;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCooler() {
        return cooler;
    }

    public void setCooler(int cooler) {
        this.cooler = cooler;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}