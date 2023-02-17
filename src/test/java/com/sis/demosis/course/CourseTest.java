package com.sis.demosis.course;

import com.sis.demosis.student.Student;
import com.sis.demosis.teacher.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

public class CourseTest {

    private Course course;
    private Teacher teacher;
    private Student student1;

    @Before
    public void setUp() {
        teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@email.com")
                .phoneNumber("555-555-5555")
                .build();

        course = Course.builder()
                .name("Test Course")
                .description("A course for testing")
                .startDate(LocalDate.of(2023, 1, 1))
                .endDate(LocalDate.of(2022, 12, 31))
                .dropDate(LocalDate.of(2022, 11, 30))
                .teacher(teacher)
                .build();

        student1 = Student.builder()
                .firstName("Jane")
                .lastName("Doe")
                .studentId("10000")
                .email("janedoe@email.com")
                .phoneNumber("555-555-5556")
                .build();

    }

    @Test
    public void testGetters() {
        assertEquals("Test Course", course.getName());
        assertEquals("A course for testing", course.getDescription());
        assertEquals(teacher, course.getTeacher());
        assertEquals(LocalDate.of(2023, 1, 1), course.getStartDate());
        assertEquals(LocalDate.of(2022, 12, 31), course.getEndDate());
        assertEquals(LocalDate.of(2022, 11, 30), course.getDropDate());
    }

    @Test
    public void testAddStudent() {
        course.addStudent(student1);
        Set<Student> students = course.getStudents();
        assertTrue(students.contains(student1));

    }

    @Test
    public void testRemoveStudent() {
        course.addStudent(student1);
        course.removeStudent(student1);
        Set<Student> students = course.getStudents();
        assertFalse(students.contains(student1));

    }
}