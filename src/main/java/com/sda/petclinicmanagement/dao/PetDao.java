package com.sda.petclinicmanagement.dao;


import com.sda.petclinicmanagement.HibernateUtils;
import com.sda.petclinicmanagement.model.Pet;
import org.hibernate.Session;

import java.util.List;

public class PetDao extends VetAndPetDao<Pet> {

    public List<Pet> getAllPets() {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("from Pet", Pet.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Pet findById(int id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Pet pet = session.find(Pet.class, id);
            session.close();
            return pet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
