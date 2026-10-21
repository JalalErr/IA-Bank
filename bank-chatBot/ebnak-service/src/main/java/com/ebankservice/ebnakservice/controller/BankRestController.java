package com.ebankservice.ebnakservice.controller;

import com.ebankservice.ebnakservice.entities.BankAccount;
import com.ebankservice.ebnakservice.service.BankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankRestController {

    BankService bankService;

    public BankRestController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getllBankAccounts(){
        return bankService.getllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id){
        return  bankService.getBankAccountById(id);
    }

    public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount){
        return bankService.saveBankAccount(bankAccount);
    }
}
