package com.bitcoin.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Validator {

    void repaint(String dir, String name){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(dir));
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(name);
        stage.show();
    }

    boolean validEmail(String email, Label lbl){
        char[] chars = email.toCharArray();
        int index = 0;

        for(int i = 0; i < email.length(); i++){
            if(chars[i] == '@'){
                index = i;
            }
        }

        String subEmail = email.substring(index);
        String preEmail = email.substring(0, index);

        Pattern emailPattern = Pattern.compile("[~`'\\]\"!@#$%^&*)(=+}{:/?\\[№; ,]");
        Matcher matchEmail = emailPattern.matcher(preEmail);

        if( !preEmail.isEmpty() && !matchEmail.find() && !preEmail.contains("\\") && (subEmail.equals("@mail.ru") || subEmail.equals("@inbox.ru") || subEmail.equals("@list.ru") || subEmail.equals("@bk.ru"))){
            lbl.setText("");
            return true;
        } else {
            lbl.setText("Неверный формат email");
            return false;
        }
    }

    boolean validPassword(String password, Label lbl){
        Pattern passwordPattern = Pattern.compile("\\W");
        Matcher matchPassword = passwordPattern.matcher(password);

        if(!password.isEmpty() && !matchPassword.find()){
            lbl.setText("");
            return true;
        } else {
            lbl.setText("Пароль содержит запрещенные символы");
            return false;
        }
    }
}