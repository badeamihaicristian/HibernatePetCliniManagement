package com.sda.petclinicmanagement;

import com.sda.petclinicmanagement.dao.*;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session s = HibernateUtils.getSessionFactory().openSession();
        s.close();
        Menu menu = new Menu();
        menu.displayMenu();
        menu.chooseOption();
    }
}
