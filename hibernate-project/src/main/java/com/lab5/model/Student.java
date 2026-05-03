package com.lab5.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    // PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // колонка name
    @Column(nullable = false)
    private String name;

    // колонка age
    private int age;

    // обов’язково пустий конструктор
    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}