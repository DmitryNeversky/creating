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
            initialize();
        } else {
            initialize();
        }
    }

    private void initialize() {
        if(identify()){
            System.out.println("Всё правильно!");
        }
    }

    public String removeAccount(){
        long id = 0;
        for(User pair : list){
            if(pair.getEmail().equals(email)){
                if(identify()) {
                    id = pair.getId();
                } else {
                    return "Неверный пароль";
                }
            }
        }
        if(id == 0) return "Аккаунт не найден!";
        return Crud.removeUser(id);
    }

    private boolean identify(){
        List<User> initList = Crud.getUser(email);
        for(User pair : initList){
            return pair.getPassword().equals(password);
        }
        return false;
    }
}
