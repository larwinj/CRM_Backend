package com.crmbackend.crm_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import com.crmbackend.crm_backend.model.Bank;
import com.crmbackend.crm_backend.model.BankLoan;
import com.crmbackend.crm_backend.model.ConnectingBankSample;
import com.crmbackend.crm_backend.service.BankLoanService;
import com.crmbackend.crm_backend.service.BankService;
import com.crmbackend.crm_backend.service.ConnectingBankSampleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @Autowired
    BankLoanService bankLoanService;

    @Autowired
    ConnectingBankSampleService bankSampleService;

    @PostMapping("/newUser")
    public String postBankInfoDetails(@RequestBody Bank bank){
        bankService.saveBankInfo(bank);
        return "Account added successfully";
    }

    @GetMapping("/getAllInfo")
    public List<Bank> ViewAllInfo() {
        return bankService.getAllBankInfo();
    }

    @GetMapping("getparticularbank/{id}")
    public Bank getMethodName(@PathVariable int id) {
        return bankService.getBank(id);
    }
    
    
    @DeleteMapping("deleteAcc/{id}")
    public String deleteAccount(@PathVariable("id") int id){
        if(bankService.getBank(id) != null){
            bankService.deleteBankinfo(id);
            return "Deleted successfully";
        }
        return "No data found";
    }

    @PutMapping("/update/{id}/{val}")
    public String updateBalance(@PathVariable int id, @PathVariable int val) {
        Bank oldbank = bankService.getBank(id);
        if(oldbank!=null){
            // int exeBank = oldbank.getBalance();
            oldbank.setBalance(oldbank.getBalance() + val);
            bankService.saveBankInfo(oldbank);
            return "Updated successfully";
        }
        return "No data found";
    }

    @PutMapping("/updatePass/{id}/{pass}")
    public String updateEmail(@PathVariable int id, @PathVariable String pass) {
        Bank oldbank = bankService.getBank(id);
        if(oldbank!=null){
            // int exeBank = oldbank.getBalance();
            oldbank.setPassword(pass);
            bankService.saveBankInfo(oldbank);
            return "Updated passWord successfully";
        }
        return "No data found";
    }

    // @GetMapping("/getbybalancecondition/{bal1}/{bal2}")
    // public List<Bank> getMethodName(@PathVariable int bal1,@PathVariable int bal2) {
    //     List<Bank> tempBank = bankService.findByBalance(bal1, bal2);
    //     JpaRepository jp = new JpaRepository<tempBank,Integer> {
    //         jp.findAll(PageRequest.of(0, 2));
    //     };
    //     return bankService.findByBalance(bal1, bal2);
    // }
    // -------------------------------------------------------
    @GetMapping("/getbybalancecondition/{bal1}/{bal2}")
    public List<Bank> getMethodName(@PathVariable int bal1, @PathVariable int bal2) {
        PageRequest pageable = PageRequest.of(0, 3,Sort.by("balance").descending());
        return bankService.findByBalance(bal1, bal2, pageable).getContent();
    }

    // --------------------------------------------------------
    

    // ------------------------------------------------------------------------------------------------------------------


    @PostMapping("/newLoanUser")
    public String postBankLoanInfo(@RequestBody BankLoan bankLoan){
        bankLoanService.saveBankLoan(bankLoan);
        return "Load added successfully";
    }

    @GetMapping("/getAllLoanInfo")
    public List<BankLoan> ViewAllLoanInfo() {
        return bankLoanService.getAllBankInfo();
    }

    @DeleteMapping("deleteLoanAcc/{id}")
    public String deleteLoanAccount(@PathVariable("id") int id){
        if(bankLoanService.getBankLoan(id) != null){
            bankLoanService.deleteBankinfo(id);
            return "Deleted successfully";
        }
        return "No data found";
    }

    @GetMapping("/getStatus")
    public List<BankLoan> getStatusDetail(@RequestParam String param) {
        return bankLoanService.getStatusDetail(param);
    }
    
    @PutMapping("/addExtraLoan/{id}/{loan}")
    public String addExtraLoan(@PathVariable int id, @PathVariable String loan) {
        BankLoan oldbankdet = bankLoanService.getBankLoan(id);
        if(oldbankdet!=null){

            String newLoan = oldbankdet.getSchemes() +"," + loan;
            oldbankdet.setSchemes(newLoan);
            bankLoanService.saveBankLoan(oldbankdet);
            return "Updated Email successfully";
        }
        return "No data found";
    }

    @PutMapping("/deletespecificloan/{id}/{loantype}")
    public String deleteSpecificLoan(@PathVariable int id, @PathVariable String loantype) {
        BankLoan oldBankLoan = bankLoanService.getBankLoan(id);
        String newloan = oldBankLoan.getSchemes();
        String modified = newloan.replace(loantype + ",", "");
        // modified = modified.replace(",,", ","); 
        // if (modified.endsWith(",")) {
        //     modified = modified.substring(0, modified.length() - 1); 
        // }
        oldBankLoan.setSchemes(modified);
        bankLoanService.saveBankLoan(oldBankLoan);
    return "Modified";
}
// ----------------------------------------------------------------------------------------------------------------------

    @PostMapping("/newSampleBankUser")
    public String postBankSampleInfoDetails(@RequestBody ConnectingBankSample bank){
        bankSampleService.saveBankSample(bank);
        return "Account added successfully";
    }

    @GetMapping("/getAllSampleBankInfo")
    public List<ConnectingBankSample> ViewAllSampleBankInfo() {
        return bankSampleService.getAllBankSampleInfo();
    }

    @DeleteMapping("deleteSampleBankAcc/{id}")
    public String deleteSampleBankAccount(@PathVariable("id") int id){
        if(bankSampleService.getBankSample(id) != null){
            bankSampleService.deleteBankSampleinfo(id);
            return "Deleted successfully";
        }
        return "No data found";
    }
    
}
