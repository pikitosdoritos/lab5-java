package com.lab6.dao;

import com.lab6.model.Student;

import java.util.List;

public interface StudentDAOInterface {

    void save(Student student);

    Student getById(Long id);

    List<Student> getAll();

    void update(Student student);

    void delete(Long id);
}