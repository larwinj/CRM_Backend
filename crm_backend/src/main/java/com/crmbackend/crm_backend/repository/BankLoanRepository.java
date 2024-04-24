package com.crmbackend.crm_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmbackend.crm_backend.model.BankLoan;

@Repository
public interface BankLoanRepository extends JpaRepository<BankLoan,Integer> {
    public List<BankLoan> findByStatusEquals(String status);
}
