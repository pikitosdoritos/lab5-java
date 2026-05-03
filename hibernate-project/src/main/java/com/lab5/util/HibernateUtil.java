package com.lab5.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.lab5.model.Student;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // беремо конфіг
                    .addAnnotatedClass(Student.class) // додаємо entity
                    .buildSessionFactory();

        } catch (Exception e) {
            System.out.println("Hibernate init error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}