package com.ebankservice.customerservice.service;

import com.ebankservice.customerservice.entities.Customer;
import com.ebankservice.customerservice.repository.CustomerRepository;
import jdk.jfr.Description;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    //Injection des depandances via le constructeur
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @McpTool(description = "Get All Customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(@McpToolParam(description = "The customer id") Long   id) {
        return customerRepository.findById(id).
                orElseThrow(()->new RuntimeException("Customer Not Found !!"));
    }

    @McpTool(description = "Save New Customer")
    public Customer saveCustomer(@McpToolParam(description = "The Customer to save (name)") Customer customer) {
        return customerRepository.save(customer);
    }
}
