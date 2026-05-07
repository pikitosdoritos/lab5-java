package com.lab6;

import com.lab6.dao.StudentDAOHQL;
import com.lab6.dao.StudentDAONativeSQL;
import com.lab6.model.*;
import com.lab6.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        System.out.println("LAB 6 START");

        // ---------- CREATE STUDENT + PROFILE ----------

        Student student = new Student("Nikita", 19);

        StudentProfile profile = new StudentProfile(
                "nikita@mail.com",
                "123456");

        student.setProfile(profile);

        // ---------- CREATE TUTOR ----------

        Tutor tutor = new Tutor(
                "Ivan Petrov",
                "OOP");

        // ---------- CREATE TEST ----------

        TestEntity test = new TestEntity(
                "OOP Test",
                "Java");

        tutor.addTest(test);

        // ---------- CREATE QUESTIONS ----------

        Question q1 = new Question(
                "What is OOP?",
                "Concept");

        Question q2 = new Question(
                "What is encapsulation?",
                "Data hiding");

        test.addQuestion(q1);
        test.addQuestion(q2);

        // ---------- LINK STUDENT WITH TEST ----------

        student.addTest(test);

        // ---------- DAO OBJECTS ----------

        StudentDAONativeSQL nativeDAO = new StudentDAONativeSQL();

        StudentDAOHQL hqlDAO = new StudentDAOHQL();

        // ---------- SAVE USING HQL ----------

        hqlDAO.save(student);

        System.out.println("Student saved with HQL");

        // ---------- SAVE USING NATIVE SQL ----------

        Student nativeStudent = new Student(
                "Native SQL User",
                21);

        nativeDAO.save(nativeStudent);

        System.out.println("Student saved with Native SQL");

        // ---------- SHOW ALL STUDENTS ----------

        System.out.println("\nALL STUDENTS:");

        hqlDAO.getAll().forEach(s -> System.out.println(
                s.getId()
                        + " "
                        + s.getName()
                        + " "
                        + s.getAge()));

        System.out.println("\nDONE");

        HibernateUtil
                .getSessionFactory()
                .close();
    }
}