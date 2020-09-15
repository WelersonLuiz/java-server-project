package com.personal.tcp.repository;

import com.personal.tcp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MessageRepository<T> {

    public void saveMessage(T message){
        System.out.println("[SERVER] - Writting into the database... ");
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(message);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        System.out.println("[SERVER] - Message saved!");
    }

}
