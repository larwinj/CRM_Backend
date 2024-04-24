package com.crmbackend.crm_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmbackend.crm_backend.model.BankLoan;
import com.crmbackend.crm_backend.repository.BankLoanRepository;

@Service
public class BankLoanService {

    @Autowired
    private BankLoanRepository bankLoanRepository;

    public BankLoan saveBankLoan(BankLoan bankLoan){
        return bankLoanRepository.save(bankLoan);
    }

    public BankLoan getBankLoan(int id){
        return bankLoanRepository.findById(id).orElse(null);
    }

    public List<BankLoan> getAllBankInfo(){
        return bankLoanRepository.findAll();
    }
    
    public void deleteBankinfo(int id){
        bankLoanRepository.deleteById(id);
    }

    public List<BankLoan> getStatusDetail(String status){
        return bankLoanRepository.findByStatusEquals(status);
    }

}
