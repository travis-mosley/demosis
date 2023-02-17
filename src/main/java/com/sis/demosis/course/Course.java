package com.sis.demosis.course;

import com.sis.demosis.student.Student;
import com.sis.demosis.teacher.Teacher;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
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

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "course_student",
          joinColumns = @JoinColumn(name = "course_id"),
          inverseJoinColumns = @JoinColumn(name = "student_id"))
  private Set<Student> students = new HashSet<>();

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
  }

  public void removeStudent(Student student) {
    students.remove(student);
  }
  public Long getId() {
    return id;
  }
}

