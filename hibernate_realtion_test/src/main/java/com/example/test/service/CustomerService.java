package com.example.test.service;

import com.example.test.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer saveCustomer(Customer customer);
    String deleteCustomer(long id);
}
