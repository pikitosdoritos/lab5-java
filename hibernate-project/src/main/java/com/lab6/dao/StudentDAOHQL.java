package com.lab6.dao;

import com.lab6.model.Student;
import com.lab6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOHQL implements StudentDAOInterface {

    @Override
    public void save(Student student) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(student);

        transaction.commit();
        session.close();
    }

    @Override
    public Student getById(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        String hql = "FROM Student WHERE id = :id";

        Student student = session
                .createQuery(hql, Student.class)
                .setParameter("id", id)
                .uniqueResult();

        session.close();

        return student;
    }

    @Override
    public List<Student> getAll() {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        String hql = "FROM Student";

        List<Student> students = session
                .createQuery(hql, Student.class)
                .getResultList();

        session.close();

        return students;
    }

    @Override
    public void update(Student student) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(student);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            session.remove(student);
        }

        transaction.commit();
        session.close();
    }
}