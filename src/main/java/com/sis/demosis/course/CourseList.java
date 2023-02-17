package com.sis.demosis.course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseList {
  private List<Course> courses;

  public CourseList() {
    courses = new ArrayList<>();
  }

  public void addCourse(Course course) {
    courses.add(course);
  }

  public void removeCourse(String name) {
    for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext();) {
      Course course = iterator.next();
      if (course.getName().equals(name)) {
        iterator.remove();
        break;
      }
    }
  }

  public Course findCourseByName(String name) {
    for (Course course : courses) {
      if (course.getName().equals(name)) {
        return course;
      }
    }
    return null;
  }
}

/*

How can I make the code above work with this code below:

package com.sis.demosis.course;

import com.sis.demosis.student.Student;
import com.sis.demosis.teacher.Teacher;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Default
@Entity
@Table(name = "course")
public class Course {

  @Default
  @ManyToMany(mappedBy = "courses")
  private Set<Student> students = new HashSet<>();

  @NotBlank
  @Size(max = 100)
  private String name;

  @NotBlank
  @Size(max = 100)
  private String description;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @NotBlank
  private LocalDate startDate;

  @NotBlank
  private LocalDate endDate;

  @NotBlank
  private LocalDate dropDate;

  @Builder
  public Course(String name, String description, Teacher teacher, LocalDate startDate, LocalDate endDate, LocalDate dropDate) {
    this.name = name;
    this.description = description;
    this.teacher = teacher;
    this.startDate = startDate;
    this.endDate = endDate;
    this.dropDate = dropDate;
  }

  public void addStudent(Student student) {
    students.add(student);
    student.getCourses().add(this);
  }

  public void removeStudent(Student student) {
    students.remove(student);
    student.getCourses().remove(this);
  }

}
 */