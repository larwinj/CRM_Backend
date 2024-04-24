package com.crmbackend.crm_backend.model;

// import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BankLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId; 

    private int bankId;

    private String schemes;
    private String status;
}
