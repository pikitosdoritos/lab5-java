package com.lab6.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private StudentProfile profile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_tests", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<TestEntity> tests = new ArrayList<>();

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addTest(TestEntity test) {

        tests.add(test);

        test.getStudents().add(this);
    }

    public Long getId() {
        return id;
    }

    // IMPORTANT FOR NATIVE SQL
    public void setId(Long id) {
        this.id = id;
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

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {

        this.profile = profile;

        if (profile != null) {
            profile.setStudent(this);
        }
    }

    public List<TestEntity> getTests() {
        return tests;
    }

    public void setTests(List<TestEntity> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}