package com.bitcoin.data.entities;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String password;

    private Integer money;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Printer printer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Price price;

    public Users(){

    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getMoney() {
        return money;
    }

    public Printer getPrinter() {
        return printer;
    }

    public Price getPrice() {
        return price;
    }
}
