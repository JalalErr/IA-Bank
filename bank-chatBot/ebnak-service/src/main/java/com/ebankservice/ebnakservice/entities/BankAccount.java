package com.ebankservice.ebnakservice.entities;

import com.ebankservice.ebnakservice.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Setter @Getter @Builder
public class BankAccount {

    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private long customerId;
    private String type;
    @Transient
    private Customer customer;

}
