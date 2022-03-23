package com.franktran.springboot.springbootfilteringsortingpagination.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Page<Student> searchStudents(Pageable pageable) {
    return studentRepository.findAll(pageable);
  }

  public Page<Student> filterStudents(String email, Pageable pageable) {
    return studentRepository.findAllByEmailContains(email, pageable);
  }
}
