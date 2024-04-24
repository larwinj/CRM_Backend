package com.crmbackend.crm_backend.repository;

// import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crmbackend.crm_backend.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {
    
    // @Query(value = "Select u from Bank u where u.balance > ?1 and u.balance < ?2")
    // public List<Bank> findByBalanceDetail(int bal1,int bal2);

    @Query(value = "Select u from Bank u where u.balance > ?1 and u.balance < ?2")
    public Page<Bank> findByBalanceDetail(int bal1, int bal2, Pageable pageable);
}