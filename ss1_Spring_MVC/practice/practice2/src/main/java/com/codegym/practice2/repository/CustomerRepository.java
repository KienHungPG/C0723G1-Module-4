package com.codegym.practice2.repository;

import com.codegym.practice2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Nguyen Van A", "nguyenvana@gmail", "Da Nang"));
        customerList.add(new Customer(2, "Nguyen Van B", "nguyenvanb@gmail", "Da Nang"));
        customerList.add(new Customer(3, "Nguyen Van C", "nguyenvanc@gmail", "Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

}
