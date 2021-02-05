package com.sda.petclinicmanagement.dao;

import com.sda.petclinicmanagement.HibernateUtils;
import com.sda.petclinicmanagement.model.Consult;
import com.sda.petclinicmanagement.model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ConsultDao {

    public List<Consult> getAllConsults() {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("from Consult", Consult.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void addConsult(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(consult);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }


    //this method is different from the usual update method. here we have 2 parameters instead of 1

    public void updateConsultDescription(Consult consult, String description) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            consult.setDescription(description);
            session.update(consult);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Consult findById(int id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Consult consult = session.find(Consult.class, id);
            session.close();
            return consult;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
