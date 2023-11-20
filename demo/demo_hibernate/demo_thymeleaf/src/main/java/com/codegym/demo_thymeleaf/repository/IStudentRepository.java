package com.codegym.demo_thymeleaf.repository;



import com.codegym.demo_thymeleaf.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    boolean add(Student student);
    Student findById(int id);
}
