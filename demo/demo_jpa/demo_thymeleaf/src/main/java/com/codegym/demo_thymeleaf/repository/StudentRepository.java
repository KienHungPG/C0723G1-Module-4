package com.codegym.demo_thymeleaf.repository;


import com.codegym.demo_thymeleaf.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        TypedQuery<Student> query = entityManager.createQuery("from Student ",Student.class);
        studentList = query.getResultList();
        return studentList;
    }

    @Transactional
    @Override
    public void add(Student student) {
        // thêm mới
      entityManager.persist(student);
      // xoá
//        Student student1 = findById(id);
//        entityManager.remove(student1);
        // udpate
//        Student studentEdit = findById(id);
//        studentEdit.setName(student.getName());
//        entityManager.merge(studentEdit);

    }

    @Override
    public Student findById(int id) {
        Student student  = entityManager.find(Student.class,id);
     return student;
    }
}
