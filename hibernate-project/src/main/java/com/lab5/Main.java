package com.lab5;

import com.lab5.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Hibernate...");

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        session.beginTransaction();

        session.getTransaction().commit();

        session.close();

        System.out.println("Done.");
    }
}