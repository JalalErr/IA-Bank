package com.ebankservice.ebnakservice.service;

import com.ebankservice.ebnakservice.entities.BankAccount;
import com.ebankservice.ebnakservice.feign.CustomerRestClient;
import com.ebankservice.ebnakservice.model.Customer;
import com.ebankservice.ebnakservice.repository.BankRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
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

    @McpTool(description = "Get All Bank Accounts")
    public List<BankAccount> getllBankAccounts(){
            return bankRepository.findAll();
    }

    public BankAccount getBankAccountById(@McpToolParam(description = "The customer id") String id){
        BankAccount bankAccount = bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Account Not Found"));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    @McpTool(description = "Save New Account")
    public BankAccount saveBankAccount(@McpToolParam(description = "The Account to save (balance)") BankAccount bankAccount){
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return bankRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @McpTool(description = "Change Blance (client name)")
    public BankAccount saveBalance(BankAccount bankAccount){
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setBalance(bankAccount.getBalance() + bankAccount.getBalance());
            return bankRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
