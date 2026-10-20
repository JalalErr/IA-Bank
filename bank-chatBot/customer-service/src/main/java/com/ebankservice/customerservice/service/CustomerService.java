package com.ebankservice.customerservice.service;

import com.ebankservice.customerservice.entities.Customer;
import com.ebankservice.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    //Injection des depandances via le constructeur
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long   id) {
        return customerRepository.findById(id).
                orElseThrow(()->new RuntimeException("Customer Not Found !!"));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
