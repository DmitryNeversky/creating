package com.bitcoin.data.database;

import com.bitcoin.data.entities.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Crud {

    public static void addUser(String email, String password){

        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Users user = new Users();
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
            Query q = session.createQuery("delete Users where id = " + id);
            q.executeUpdate();
            session.getTransaction().commit();
            return "Аккаунт удален!";
        } catch (Throwable cause){
            return "Ошибка: " + cause;
        }
    }

    public static List<Users> getUser(String email) {
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM Users where email = :usernameParam");
            query.setParameter("usernameParam", email);
            return (List<Users>) query.list();
        }
    }

    public static List<Users> getUsers(){
        List<Users> list = null;
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM Users");
            list = (List<Users>) query.list();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
        return list;
    }
}
