package com.bitcoin.data.database;

import com.bitcoin.data.entities.Price;
import com.bitcoin.data.entities.Printer;
import com.bitcoin.data.entities.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Crud {

    public static void addUser(String email, String password){

        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Users user = new Users(email, password);
            user.setMoney(100);

            Printer printer = new Printer(1, 1, 2000, 10, 1000);

            Price price = new Price(10, 15, 20 ,10);

            user.setPrinter(printer);
            user.setPrice(price);

            session.save(user);
            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public static void removeUser(Long id){
        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Query q = session.createQuery("delete Users where id = " + id);
            q.executeUpdate();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public static List<Users> getUser(String email) {

        List list = null;

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM Users where email=:emailParam");
            query.setParameter("emailParam", email);
            list = query.list();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }

        return (List<Users>) list;
    }

    public static List<Users> getUsers(){

        List list = null;

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM Users");
            list = query.list();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }

        return (List<Users>) list;
    }

    public static Printer getPrinter(String email){
        List<Users> list = getUser(email);
        Printer printer = null;

        for(Users pair : list){
            printer = pair.getPrinter();
        }

        return printer;
    }

    public static Price getPrice(String email){
        List<Users> list = getUser(email);
        Price price = null;

        for(Users pair : list){
            price = pair.getPrice();
        }

        return price;
    }
}
