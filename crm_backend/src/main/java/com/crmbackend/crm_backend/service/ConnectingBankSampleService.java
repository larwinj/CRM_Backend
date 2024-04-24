package com.crmbackend.crm_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmbackend.crm_backend.model.ConnectingBankSample;
import com.crmbackend.crm_backend.repository.ConnectingBankSampleRepository;

@Service
public class ConnectingBankSampleService {

    @Autowired
    private ConnectingBankSampleRepository BankSample;

    public ConnectingBankSample saveBankSample(ConnectingBankSample bank){
        return BankSample.save(bank);
    }

    public ConnectingBankSample getBankSample(int id){
        return BankSample.findById(id).orElse(null);
    }

    public List<ConnectingBankSample> getAllBankSampleInfo(){
        return BankSample.findAll();
    }

    public void deleteBankSampleinfo(int id){
        BankSample.deleteById(id);
    }
}
