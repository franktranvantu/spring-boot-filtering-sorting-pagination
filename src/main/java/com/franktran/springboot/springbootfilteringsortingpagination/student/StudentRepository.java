package com.franktran.springboot.springbootfilteringsortingpagination.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
  Page<Student> findAllByEmailContains(String email, Pageable pageable);
}
