package com.bitcoin.data.database;

import com.bitcoin.data.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Authorize {

    public static void auth(String email, String password){
        List<User> list = null;

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM User");
            list = (List<User>) query.list();

            session.getTransaction().commit();
        } catch (Throwable cause){
            cause.printStackTrace();
        }

        if(list != null && !list.isEmpty()){
            for(User pair : list){
                System.out.println(pair.getEmail());
                if(pair.getEmail().equals(email)){
                    System.out.println("Пользователя с таким Email уже существует!"); // Меняем сцену и загружаем данные пользователя
                } else {
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
                    System.out.println("Пользователь успешно добавлен!");
                }
            }
        } else {
            System.out.println("Таблица пуста =(");
        }
    }
}
