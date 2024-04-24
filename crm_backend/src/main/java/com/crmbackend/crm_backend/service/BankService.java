package com.crmbackend.crm_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crmbackend.crm_backend.model.Bank;
import com.crmbackend.crm_backend.repository.BankRepository;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Bank saveBankInfo(Bank bank){
        return bankRepository.save(bank);
    }

    public Bank getBank(int id){
        return bankRepository.findById(id).orElse(null);
    }

    // public Bank getParticularBank(int id){
    //     return bankRepository.findById(id).orElse(null);
    // }

    public List<Bank> getAllBankInfo(){
        return bankRepository.findAll();
    }

    public void deleteBankinfo(int id){
        bankRepository.deleteById(id);
    }

    public Page<Bank> findByBalance(int bal1, int bal2, Pageable pageable) {
        return bankRepository.findByBalanceDetail(bal1, bal2, pageable);
    }
    

}
