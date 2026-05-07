package com.lab6.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tutors")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String subject;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<TestEntity> tests = new ArrayList<>();

    public Tutor() {
    }

    public Tutor(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void addTest(TestEntity test) {
        tests.add(test);
        test.setTutor(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public List<TestEntity> getTests() {
        return tests;
    }
}