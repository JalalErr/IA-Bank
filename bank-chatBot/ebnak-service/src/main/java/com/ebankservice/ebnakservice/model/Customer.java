package com.ebankservice.ebnakservice.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Customer {

    private Long id;
    private String name;
    private String email;
}
