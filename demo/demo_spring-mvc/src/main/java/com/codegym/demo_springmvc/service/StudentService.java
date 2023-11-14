package com.codegym.demo_springmvc.service;

import com.codegym.demo_springmvc.model.Student;
import com.codegym.demo_springmvc.repository.IStudentRepository;
import com.codegym.demo_springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return null;
    }
}
