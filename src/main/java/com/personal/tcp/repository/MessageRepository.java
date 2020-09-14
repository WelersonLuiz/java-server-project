package com.personal.tcp.repository;

import com.personal.tcp.entities.message.type.TextMessage;
import com.personal.tcp.entities.message.type.UserMessage;
import com.personal.tcp.util.HibernateUtil;
import com.personal.tcp.entities.message.Message;
import com.personal.tcp.entities.message.type.UserInfoMessage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository {

    public void saveTextMessage(TextMessage message){
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
    }

    public void saveUserInfoMessage(UserInfoMessage message){
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
    }

}
