package com.bitcoin.data.database;

import org.hibernate.Session;

class Transmitter extends Data{

    Transmitter(){

    }

    Transmitter(Object object){
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            session.save(object);

            session.getTransaction().commit();
        } catch(Throwable cause) {
            cause.printStackTrace();
        }
    }
}
