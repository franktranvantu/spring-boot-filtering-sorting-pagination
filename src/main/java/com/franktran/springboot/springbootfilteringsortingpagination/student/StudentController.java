package com.franktran.springboot.springbootfilteringsortingpagination.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/search")
  public ResponseEntity<Page<Student>> searchStudents(Pageable pageable) {
    return new ResponseEntity<>(studentService.searchStudents(pageable), HttpStatus.OK);
  }

  @GetMapping("/search/filter")
  public ResponseEntity<Page<Student>> filterStudents(@RequestParam String email, Pageable pageable) {
    return new ResponseEntity<>(studentService.filterStudents(email, pageable), HttpStatus.OK);
  }
}
