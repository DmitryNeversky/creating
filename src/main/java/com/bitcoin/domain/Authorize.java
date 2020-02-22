package com.bitcoin.domain;

import com.bitcoin.data.entities.Users;

public class Authorize {

    public static void auth(){
        String sql = "From " + Users.class.getSimpleName();
        System.out.println("sql = " + sql);
    }
}
