package com.franktran.springboot.springbootfilteringsortingpagination.student;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StudentBootStrap implements CommandLineRunner {

  private final StudentRepository studentRepository;

  public StudentBootStrap(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public void run(String... args) {
    Faker faker = new Faker();
    List<Student> students = Stream.iterate(1, i -> i + 1)
        .map(i -> new Student(faker.name().name(), String.format("faker%d@gmail.com", i), faker.date().birthday(10, 50).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
        .limit(100)
        .collect(Collectors.toList());

    studentRepository.saveAll(students);
  }
}
