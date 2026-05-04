package com.lab5.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tests")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subject;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @ManyToMany(mappedBy = "tests")
    private List<Student> students = new ArrayList<>();

    public TestEntity() {
    }

    public TestEntity(String title, String subject) {
        this.title = title;
        this.subject = subject;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setTest(this);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Student> getStudents() {
        return students;
    }
}