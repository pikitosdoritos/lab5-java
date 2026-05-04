package com.lab5;

import com.lab5.dao.StudentDAO;
import com.lab5.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    @Test
    void testSaveStudent() {

        // створюємо DAO
        StudentDAO dao = new StudentDAO();

        // створюємо студента
        Student student = new Student("JUnit User", 20);

        // зберігаємо в БД
        dao.save(student);

        // перевіряємо що ID згенерувався (значить запис є в БД)
        assertNotNull(student.getId(), "ID має бути створений після збереження");

        System.out.println("TEST PASSED: Student saved, id = " + student.getId());
    }

    @Test
    void testGetStudent() {

        StudentDAO dao = new StudentDAO();

        // створюємо і зберігаємо студента
        Student student = new Student("Read Test", 22);
        dao.save(student);

        // дістаємо з БД
        Student fromDb = dao.getById(student.getId());

        // перевірки
        assertNotNull(fromDb, "Студент має існувати в БД");
        assertEquals("Read Test", fromDb.getName(), "Ім'я не співпадає");

        System.out.println("TEST PASSED: Student read correctly");
    }

    @Test
    void testUpdateStudent() {

        StudentDAO dao = new StudentDAO();

        // створюємо студента
        Student student = new Student("Old Name", 25);
        dao.save(student);

        // змінюємо дані
        student.setName("New Name");
        dao.update(student);

        // перевіряємо
        Student updated = dao.getById(student.getId());

        assertNotNull(updated);
        assertEquals("New Name", updated.getName(), "Оновлення не спрацювало");

        System.out.println("TEST PASSED: Student updated");
    }

    @Test
    void testDeleteStudent() {

        StudentDAO dao = new StudentDAO();

        // створюємо студента
        Student student = new Student("Delete Test", 30);
        dao.save(student);

        Long id = student.getId();

        // видаляємо
        dao.delete(id);

        // перевіряємо
        Student deleted = dao.getById(id);

        assertNull(deleted, "Студент має бути видалений");

        System.out.println("TEST PASSED: Student deleted");
    }
}