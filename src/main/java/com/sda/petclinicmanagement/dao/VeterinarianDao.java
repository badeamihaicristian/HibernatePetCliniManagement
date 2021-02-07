package com.sda.petclinicmanagement.dao;

import com.sda.petclinicmanagement.HibernateUtils;
import com.sda.petclinicmanagement.model.Consult;
import com.sda.petclinicmanagement.model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class VeterinarianDao extends VetAndPetDao<Veterinarian> {

    public List<Veterinarian> getAllVeterinarians() {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Query<Veterinarian> query = session.createQuery("from Veterinarian", Veterinarian.class);
//            Pagination  methods below
//            query.setFirstResult(2);
//            query.setMaxResults(2);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Veterinarian findById(int id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Veterinarian vet = session.find(Veterinarian.class, id);
            session.close();
            return vet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
