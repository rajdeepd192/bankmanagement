package com.areteans.bankmanagement.controller;

import com.areteans.bankmanagement.service.Accountservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "close")
public class DeleteAccount {
    private final Accountservice accountservice;

    @DeleteMapping(value = "account/{account_no}")
    public void deleteacc(@PathVariable("account_no") Long account_no){
        accountservice.closeAcc(account_no);
    }
}
