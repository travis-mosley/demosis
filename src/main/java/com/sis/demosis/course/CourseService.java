package com.sis.demosis.course;

import com.sis.demosis.student.Student;
import com.sis.demosis.teacher.Teacher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourseForAdmin(String name, String description, LocalDate startDate, LocalDate endDate, LocalDate dropDate) {
        Course course = Course.builder()
                .name(name)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .dropDate(dropDate)
                .build();
        return courseRepository.save(course);
    }

    public void assignTeacherToCourse(Long courseId, Teacher teacher) {
        Course course = courseRepository.getOne(courseId);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public Set<Student> getStudents(Long courseId) {
        Course course = courseRepository.getOne(courseId);
        return course.getStudents();
    }

    public void addStudent(Long courseId, Student student) {
        Course course = courseRepository.getOne(courseId);
        course.addStudent(student);
        courseRepository.save(course);
    }

    public void removeStudent(Long courseId, Student student) {
        Course course = courseRepository.getOne(courseId);
        course.removeStudent(student);
        courseRepository.save(course);
    }
}