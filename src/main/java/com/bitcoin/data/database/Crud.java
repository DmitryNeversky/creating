package com.bitcoin.data.database;

import com.bitcoin.data.entities.Price;
import com.bitcoin.data.entities.Printer;
import com.bitcoin.data.entities.Users;
import org.hibernate.Session;

public class Crud {

    public static void addUser(String email, String password){

        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Printer printer = new Printer(1, 1, 2000, 40, 1000);

            Price price = new Price(10, 15, 20 ,10);

            session.save(new Users(email, password, 100, printer, price));

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public static void saveUser(String email, double money, Printer printer, Price price){
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            session.update(printer);
            session.update(price);

            Users user = session.byNaturalId(Users.class).using("email", email).load();

            user.setMoney(money);

            session.getTransaction().commit();
        } catch (Throwable cause) {
            cause.printStackTrace();
        }
    }

    public static void removeUser(String email){
        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Users user = session.byNaturalId(Users.class).using("email", email).load();

            session.delete(user);

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public static Users getUser(String email) {
        Users user = null;

        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            user = session.byNaturalId(Users.class).using("email", email).load();

            session.getTransaction().commit();
        } catch (Throwable cause) {
            cause.printStackTrace();
        }

        return user;
    }

    public static Printer getPrinter(String email){
        Users user = getUser(email);

        return user.getPrinter();
    }

    public static Price getPrice(String email){
        Users user = getUser(email);

        return user.getPrice();
    }
}
