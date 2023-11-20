package com.codegym.demo_thymeleaf.service;


import com.codegym.demo_thymeleaf.model.Student;
import com.codegym.demo_thymeleaf.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
