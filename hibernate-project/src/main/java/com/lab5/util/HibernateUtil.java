package com.lab5.util;

import com.lab5.model.Question;
import com.lab5.model.Student;
import com.lab5.model.StudentProfile;
import com.lab5.model.TestEntity;
import com.lab5.model.Tutor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(StudentProfile.class)
                    .addAnnotatedClass(Tutor.class)
                    .addAnnotatedClass(TestEntity.class)
                    .addAnnotatedClass(Question.class)
                    .buildSessionFactory();

        } catch (Exception e) {
            System.out.println("Hibernate initialization error");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}