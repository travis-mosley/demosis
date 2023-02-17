package com.sis.demosis.student;

import com.sis.demosis.account.AccountType;
import com.sis.demosis.course.Course;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@Data
@Builder
public class Student {


  @NotBlank
  @Size(max = 50)
  @Column(name = "first_name")
  private String firstName;

  @NotBlank
  @Size(max = 50)
  @Column(name = "last_name")
  private String lastName;

  @NotBlank
  @Size(min = 5, max = 5)
  private String studentId;

  @NotBlank
  @Size(max = 100)
  @Email
  @Column(unique = true)
  private String email;

  @NotBlank
  @Size(max = 100)
  private String address;

  @NotBlank
  @Size(min = 10, max = 10)
  private String phoneNumber;

  @NotBlank
  @Enumerated(EnumType.STRING)
  @Column(name = "account_type")
  private AccountType STUDENT;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(
          name = "course_student",
          joinColumns = { @JoinColumn(name = "student_id") },
          inverseJoinColumns = { @JoinColumn(name = "course_name") }
  )
  private Set<Course> courses = new HashSet<>();

  public void enrollCourse(Course course) {
    if (courses == null) {
      courses = new HashSet<>();
    }
    courses.add(course);
    course.getStudents().add(this);
  }

  public void removeCourse(Course course) {
    if (courses == null) {
      courses = new HashSet<>();
    }
    courses.remove(course);
    course.getStudents().remove(this);
  }

}