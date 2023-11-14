package com.codegym.demo_springmvc.repository;

import com.codegym.demo_springmvc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh1"));
        studentList.add(new Student(2,"chanh2"));
        studentList.add(new Student(3,"chanh3"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
