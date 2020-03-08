package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Users;
import javafx.scene.control.Label;

public class Controller {
    private String email;
    private String password;

    private Users user;

    public Controller(String email, String password){
        this.email = email;
        this.password = password;
        user = Crud.getUser(email);
    }

    public boolean auth(Label emailLabel, Label passwordLabel){
        if(user != null) {
            if (!user.getEmail().equals(email)) {
                emailLabel.setText("Аккаунт не найден");
                return false;
            } else {
                emailLabel.setText("");
                if (user.getPassword().equals(password)) {
                    return true;
                } else {
                    passwordLabel.setText("Пароли не совпадают");
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public boolean registry(Label emailLabel){
        if(!user.getEmail().equals(email)) {
            Crud.addUser(email, password);
            return true;
        } else {
            emailLabel.setText("Такой аккаунт уже существует");
            return false;
        }
    }

    public void removeAccount(){
        Crud.removeUser(email);
    }
}
