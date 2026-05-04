package com.lab5;

import com.lab5.dao.StudentDAO;
import com.lab5.model.Student;
import com.lab5.model.StudentProfile;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Hibernate...");

        StudentDAO studentDAO = new StudentDAO();

        Student student = new Student("Nikita", 19);
        StudentProfile profile = new StudentProfile("nikita@mail.com", "123456");

        student.setProfile(profile);

        studentDAO.save(student);

        System.out.println("Done.");
    }
}