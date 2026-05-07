package com.lab6.dao;

import com.lab6.model.Student;
import com.lab6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class StudentDAONativeSQL implements StudentDAOInterface {

    @Override
    public void save(Student student) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        String sql = """
                INSERT INTO students(name, age)
                VALUES (:name, :age)
                RETURNING id
                """;

        NativeQuery<?> query = session.createNativeQuery(sql);

        query.setParameter("name", student.getName());
        query.setParameter("age", student.getAge());

        Long generatedId = ((Number) query.getSingleResult()).longValue();

        student.setId(generatedId);

        transaction.commit();
        session.close();
    }

    @Override
    public Student getById(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        String sql = "SELECT * FROM students WHERE id = :id";

        Student student = session
                .createNativeQuery(sql, Student.class)
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

        String sql = "SELECT * FROM students";

        List<Student> students = session
                .createNativeQuery(sql, Student.class)
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

        String sql = """
                UPDATE students
                SET name = :name,
                    age = :age
                WHERE id = :id
                """;

        session.createNativeQuery(sql)
                .setParameter("name", student.getName())
                .setParameter("age", student.getAge())
                .setParameter("id", student.getId())
                .executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM students WHERE id = :id";

        session.createNativeQuery(sql)
                .setParameter("id", id)
                .executeUpdate();

        transaction.commit();
        session.close();
    }
}