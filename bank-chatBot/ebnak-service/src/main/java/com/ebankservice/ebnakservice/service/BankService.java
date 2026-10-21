package com.ebankservice.ebnakservice.service;

import com.ebankservice.ebnakservice.entities.BankAccount;
import com.ebankservice.ebnakservice.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BankService {

    private BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<BankAccount> getllBankAccounts(){
            return bankRepository.findAll();
    }

    public BankAccount getBankAccountById(String id){
        return  bankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Account Not Found"));
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankRepository.save(bankAccount);
    }
}
