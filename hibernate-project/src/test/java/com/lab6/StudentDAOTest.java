package com.lab6;

import com.lab6.dao.StudentDAOHQL;
import com.lab6.dao.StudentDAONativeSQL;
import com.lab6.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    @Test
    void testSaveWithHQL() {

        StudentDAOHQL dao = new StudentDAOHQL();

        Student student = new Student(
                "HQL Test",
                20);

        dao.save(student);

        assertNotNull(student.getId());

        System.out.println(
                "HQL SAVE TEST PASSED");
    }

    @Test
    void testSaveWithNativeSQL() {

        StudentDAONativeSQL dao = new StudentDAONativeSQL();

        Student student = new Student(
                "Native SQL Test",
                21);

        dao.save(student);

        assertNotNull(student.getId());

        System.out.println(
                "NATIVE SQL SAVE TEST PASSED");
    }

    @Test
    void testGetAllHQL() {

        StudentDAOHQL dao = new StudentDAOHQL();

        assertNotNull(
                dao.getAll());

        System.out.println(
                "HQL GET ALL TEST PASSED");
    }

    @Test
    void testGetAllNativeSQL() {

        StudentDAONativeSQL dao = new StudentDAONativeSQL();

        assertNotNull(
                dao.getAll());

        System.out.println(
                "NATIVE SQL GET ALL TEST PASSED");
    }
}