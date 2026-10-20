package com.ebankservice.customerservice.controller;

import com.ebankservice.customerservice.entities.Customer;
import com.ebankservice.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerService customerService;

    //Injection des depandances via Le constructeur
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {return customerService.getAllCustomers();}

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id) {return customerService.getCustomerById(id);}

    @PostMapping("/save")
    public Customer saveCusomer(@RequestBody Customer customer) {return customerService.saveCustomer(customer);}
}
