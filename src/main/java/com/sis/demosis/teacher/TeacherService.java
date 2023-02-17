package com.sis.demosis.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

  @Autowired
  private TeacherRepository teacherRepository;

  public Teacher getTeacherByName(String firstName, String lastName) {
    return teacherRepository.findByFirstNameAndLastName(firstName, lastName);
  }

}
