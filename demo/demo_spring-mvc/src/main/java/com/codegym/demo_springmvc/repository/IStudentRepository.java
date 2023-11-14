package com.codegym.demo_springmvc.repository;

import com.codegym.demo_springmvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
