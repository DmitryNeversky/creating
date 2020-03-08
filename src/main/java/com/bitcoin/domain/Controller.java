package com.bitcoin.domain;

import com.bitcoin.data.database.Crud;
import com.bitcoin.data.entities.Users;
import javafx.scene.control.Label;

import java.util.List;

public class Controller {
    private String email;
    private String password;

    public Controller(String email, String password){
        this.email = email;
        this.password = password;
    }

    public boolean auth(Label emailLabel, Label passwordLabel){
        List<Users> list = Crud.getUsers();

        int search = 0;

        for(Users pair : list){
            if(pair.getEmail().equals(email))
                search++;
        }

        if(search > 0) {
            Users user = Crud.getUser(email);

            if (user.getPassword().equals(password)) {
                passwordLabel.setText("");
                return true;
            } else {
                passwordLabel.setText("Пароли не совпадают");
                return false;
            }
        } else {
            emailLabel.setText("Аккаунт не найден");
            return false;
        }
    }

    public boolean registry(Label emailLabel){
        Users user = Crud.getUser(email);

        if (user == null) {
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