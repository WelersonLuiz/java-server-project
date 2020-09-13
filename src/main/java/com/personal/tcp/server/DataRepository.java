package com.personal.tcp.server;

import com.personal.tcp.Util.HibernateUtil;
import com.personal.tcp.entities.Message;
import com.personal.tcp.entities.messages.UserInfo;
import com.personal.tcp.entities.messages.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    public DataRepository() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }

    public void saveData(Message message){
        Transaction transaction = null;
        User info = (User) message;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(info.getData());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<UserInfo> findAllData(){
        List<UserInfo> listData = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            listData = session.createQuery("from Data", UserInfo.class).getResultList();
            listData.forEach(d -> System.out.println(d.getNome()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

}
