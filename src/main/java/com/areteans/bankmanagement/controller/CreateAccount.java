package com.areteans.bankmanagement.controller;


import com.areteans.bankmanagement.model.Account;
import com.areteans.bankmanagement.service.Accountservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "account")
public class CreateAccount {
    private final Accountservice accountservice;

    @CrossOrigin
    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account accountdata(@RequestBody Account account){
        return accountservice.createAcc(account);
    }
}
