package com.codegym.practice2.repository;

import com.codegym.practice2.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
