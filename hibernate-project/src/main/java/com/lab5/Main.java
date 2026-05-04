package com.lab5;

import com.lab5.dao.StudentDAO;
import com.lab5.model.Student;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Hibernate...");

        StudentDAO studentDAO = new StudentDAO();

        Student student = new Student("Nikita", 19);

        studentDAO.saveStudent(student);

        System.out.println("Done.");
    }
}