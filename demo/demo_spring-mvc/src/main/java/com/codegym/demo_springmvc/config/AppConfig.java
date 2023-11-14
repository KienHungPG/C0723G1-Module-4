package com.codegym.demo_springmvc.config;


import com.codegym.demo_springmvc.repository.StudentRepository;
import com.codegym.demo_springmvc.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public StudentRepository studentRepository(){
        return new StudentRepository();
    }
//    @Bean
//    public StudentService studentService(){
//        return new StudentService();
//    }
}
