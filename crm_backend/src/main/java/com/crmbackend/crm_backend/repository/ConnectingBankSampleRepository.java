package com.crmbackend.crm_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmbackend.crm_backend.model.ConnectingBankSample;

@Repository
public interface ConnectingBankSampleRepository extends JpaRepository<ConnectingBankSample,Integer> {
    
}
