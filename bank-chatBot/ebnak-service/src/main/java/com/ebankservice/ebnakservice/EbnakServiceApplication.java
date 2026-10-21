package com.ebankservice.ebnakservice;

import com.ebankservice.ebnakservice.entities.BankAccount;
import com.ebankservice.ebnakservice.service.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbnakServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbnakServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankService bankService) {
        return args -> {
            for (int i = 1; i <= 3; i++) {
                bankService.saveBankAccount(BankAccount.builder()
                        .type(Math.random() > 0.5? "CUURENT-ACCOUNT" : "SAVING-ACCOUNT")
                        .balance(1000 + Math.random() * 600000)
                        .customerId(i)
                        .build());

            }
        };
    }
}
