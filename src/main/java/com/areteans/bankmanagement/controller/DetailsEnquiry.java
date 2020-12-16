package com.areteans.bankmanagement.controller;


import com.areteans.bankmanagement.model.Account;
import com.areteans.bankmanagement.service.Accountservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "enquiry")
public class DetailsEnquiry {
    private final Accountservice accountservice;

    @GetMapping(path = "accountdetails")
    public Account accdetails(@RequestParam(value = "account_no")Long account_no){
        return accountservice.getAccountByNo(account_no);
    }

//    @GetMapping(path = "balance")
//    public Map<String, Object> baldetails(@RequestParam(value = "account_no")Long account_no){
//        return accountservice.BalanceDetails(account_no);
//    }
}
