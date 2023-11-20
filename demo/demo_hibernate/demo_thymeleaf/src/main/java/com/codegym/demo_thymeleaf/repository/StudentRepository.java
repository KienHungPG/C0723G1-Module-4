package com.codegym.demo_thymeleaf.repository;


import com.codegym.demo_thymeleaf.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> query = session.createQuery("from Student",Student.class);
        TypedQuery<Student> query = session.createNativeQuery("select * from student",Student.class);
        studentList = query.getResultList();
        session.close();
        return studentList;
    }

    @Override
    public boolean add(Student student) {
      Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.persist(student);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Student> query = session.createQuery("from Student where id = :id1",Student.class);
        query.setParameter("id1",id);
        Student student = query.getSingleResult();
        return student;
    }
}
