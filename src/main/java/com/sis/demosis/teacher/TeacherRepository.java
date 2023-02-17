package com.sis.demosis.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

  Teacher findByFirstNameAndLastName(String firstName, String lastName);
};

