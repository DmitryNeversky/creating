package com.bitcoin.data.database;

import com.bitcoin.data.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Crud {

    public static void addUser(String email, String password){

        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            session.save(user);
            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
    }

    public static String removeUser(Long id){
        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Query q = session.createQuery("delete User where id = " + id);
            q.executeUpdate();
            session.getTransaction().commit();
            return "Аккаунт удален!";
        } catch (Throwable cause){
            return "Ошибка: " + cause;
        }
    }

    public static List<User> getUser(String email) {
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM User where email = :usernameParam");
            query.setParameter("usernameParam", email);
            return (List<User>) query.list();
        }
    }

    public static List<User> getUsers(){
        List<User> list = null;
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM User");
            list = (List<User>) query.list();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
        return list;
    }
}
