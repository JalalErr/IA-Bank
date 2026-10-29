package com.ebankservice.ebnakservice.service;

import com.ebankservice.ebnakservice.entities.BankAccount;
import com.ebankservice.ebnakservice.feign.CustomerRestClient;
import com.ebankservice.ebnakservice.model.Customer;
import com.ebankservice.ebnakservice.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BankService {

    private BankRepository bankRepository;
    private CustomerRestClient customerRestClient;

    public BankService(BankRepository bankRepository, CustomerRestClient customerRestClient) {

        this.bankRepository = bankRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getllBankAccounts(){
            return bankRepository.findAll();
    }

    public BankAccount getBankAccountById(String id){
        BankAccount bankAccount = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Account Not Found"));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return bankRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
