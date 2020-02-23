package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.User;

import java.util.List;

public class Authorize {
    private String email;
    private String password;
    private List<User> list = Crud.getUsers();

    public Authorize(String email, String password){
        this.email = email;
        this.password = password;
    }

    public void auth(){
        int contain = 0;

        if(list != null && !list.isEmpty()) {
            for (User pair : list) {
                if (pair.getEmail().equals(email)) {
                    contain++;
                }
            }
        }

        if(contain == 0) {
            Crud.addUser(email, password);
            System.out.println("Пользователь добавлен!");
        } else {
            initialize();
        }
    }

    private void initialize() {
        List<User> initList = Crud.getUser(email);
        for(User pair : initList){
            if(pair.getPassword().equals(password)){
                System.out.println("Всё правильно!");
            }
        }
        // Выгружать значения из бд
    }

    public void removeAccount(){
        System.out.println("Робит");
    }
}
