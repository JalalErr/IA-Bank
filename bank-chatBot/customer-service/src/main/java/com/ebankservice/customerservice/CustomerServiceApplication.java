package com.ebankservice.customerservice;

import com.ebankservice.customerservice.entities.Customer;
import com.ebankservice.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(CustomerService customerService) {
        return args -> {
            List<String> names = List.of("Ahmed", "Imane", "Ali");
            names.forEach(name -> {
                customerService.saveCustomer(Customer.builder()
                        .name(name).email(name + "@gmail.com")
                        .build());
            });
         };
    }
}
