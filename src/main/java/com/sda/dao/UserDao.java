package com.sda.dao;

import com.sda.model.User;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDao extends GenericDao<User> {

    public User findByUsernameAndPassword(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //use the class name User instead of the table name
        Query query = session.createQuery("from User where username = :username AND password = :password ");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> list = query.getResultList();

        transaction.commit();
        session.close();
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
