package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Users;
import javafx.scene.control.Label;

import java.util.List;

public class Controller {
    private String email;
    private String password;
    private List<Users> list = Crud.getUsers();

    public Controller(String email, String password){
        this.email = email;
        this.password = password;
    }

    public boolean auth(Label emailLabel, Label passwordLabel){
        if(!findAccount()){
            emailLabel.setText("Аккаунт не найден");
            return false;
        } else {
            emailLabel.setText("");
            if(identify()) {
                return true;
            } else {
                passwordLabel.setText("Пароли не совпадают");
                return false;
            }
        }
    }

    public boolean registry(){
        if(findAccount()) {
            Crud.addUser(email, password);
            return true;
        } else {
            return false;
        }
    }

    private boolean findAccount(){

        int search = 0;

        if(list != null && !list.isEmpty()) {
            for (Users pair : list) {
                if (pair.getEmail().equals(email)) {
                    search++;
                }
            }
            return search > 0;
        } else {
            return false;
        }
    }

//    public String removeAccount(){
//        long id = 0;
//        for(Users pair : list){
//            if(pair.getEmail().equals(email)){
//                if(identify()) {
//                    id = pair.getId();
//                } else {
//                    return "Неверный пароль";
//                }
//            }
//        }
//        if(id == 0) return "Аккаунт не найден!";
//        return Crud.removeUser(id);
//    }

    // Не робит

    private boolean identify(){
        List<Users> initList = Crud.getUser(email);

        if(!initList.isEmpty()) {
            for (Users pair : initList) {
                if (!pair.getPassword().equals(password)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
