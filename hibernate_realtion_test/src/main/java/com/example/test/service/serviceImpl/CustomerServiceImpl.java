package com.example.test.service.serviceImpl;

import com.example.test.entity.Customer;
import com.example.test.repository.CustomerRepository;
import com.example.test.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return "deleted";
    }
}
