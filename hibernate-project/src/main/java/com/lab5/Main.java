package com.lab5;

import com.lab5.dao.StudentDAO;
import com.lab5.model.*;
import com.lab5.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Hibernate...");

        StudentDAO studentDAO = new StudentDAO();

        // ---------- CREATE STUDENT + PROFILE ----------

        Student student = new Student("Nikita", 19);
        StudentProfile profile = new StudentProfile("nikita@mail.com", "123456");

        student.setProfile(profile);

        // ---------- CREATE TUTOR ----------

        Tutor tutor = new Tutor("Ivan Petrov", "OOP");

        // ---------- CREATE TEST ----------

        TestEntity test = new TestEntity("OOP Test", "Java");

        tutor.addTest(test);

        // ---------- CREATE QUESTIONS ----------

        Question q1 = new Question("What is OOP?", "Concept");
        Question q2 = new Question("What is encapsulation?", "Data hiding");

        test.addQuestion(q1);
        test.addQuestion(q2);

        // ---------- LINK STUDENT WITH TEST ----------

        student.addTest(test);

        // ---------- SAVE ----------

        studentDAO.save(student);

        System.out.println("Done.");
        
        HibernateUtil.getSessionFactory().close();
    }
}