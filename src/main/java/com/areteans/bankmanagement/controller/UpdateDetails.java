package com.areteans.bankmanagement.controller;

import com.areteans.bankmanagement.service.Accountservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "update")
public class UpdateDetails {
    private final Accountservice accountservice;

    @PutMapping(path = "details", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object>updatedetails(@RequestBody Map<String,Object>account){
        return accountservice.updateaccount(account);
    }

    @PutMapping(path = "trans", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object>transdetails(@RequestBody Map<String,Object>account){
        return accountservice.transactions(account);
    }
}
