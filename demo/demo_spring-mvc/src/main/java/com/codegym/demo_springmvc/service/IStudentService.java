package com.codegym.demo_springmvc.service;

import com.codegym.demo_springmvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
