package com.crmbackend.crm_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectingBankSample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String username;
    private String city;
    private String state;
    // @JoinColumn(name = "bank_id", referencedColumnName = "accNo")
    @ManyToOne
    @JsonBackReference
    private Bank bank;
}