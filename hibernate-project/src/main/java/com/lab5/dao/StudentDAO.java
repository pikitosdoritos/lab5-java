package com.lab5.dao;

import com.lab5.model.Student;
import com.lab5.util.HibernateUtil;
import org.hibernate.Session;

public class StudentDAO {

    // INSERT
    public void saveStudent(Student student) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        session.beginTransaction();

        session.persist(student);

        session.getTransaction().commit();

        session.close();

        System.out.println("Student saved!");
    }
}