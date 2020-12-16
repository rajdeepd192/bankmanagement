package com.areteans.bankmanagement.service;


import com.areteans.bankmanagement.model.Account;
import com.areteans.bankmanagement.repository.Accountrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountservice {
    private final Accountrepository accountrepository;
    private final JdbcTemplate jdbcTemplate;

    public Account createAcc(Account account){
        return accountrepository.save(account);
    }

    public void closeAcc(long id){
         accountrepository.deleteById(id);
    }

    public Map<String,Object>updateaccount(Map<String,Object>account){
    jdbcTemplate.update("update Accounts set customer_name=?,address=?,contact_no=? where account_no = ?",
            account.get("customer_name"),
            account.get("address"),
            Long.parseLong((String) account.get("contact_no")),
            Long.parseLong((String) account.get("account_no")));
    return account;
    }

    public Map<String,Object>transactions(Map<String,Object>account){
        jdbcTemplate.update("update Accounts set credit=? where account_no=?",
                Long.parseLong((String) account.get("credit")),
                Long.parseLong((String) account.get("account_no")));
        return account;
    }

    public Account getAccountByNo(Long id){
    Optional<Account> emp = accountrepository.findById(id);
        if (emp.isPresent()) {
        return emp.get();
    }
        return null; }

//    public Map<String, Object> BalanceDetails(Long account_no) {
//        return jdbcTemplate.queryForMap("select account_no, SUM(opening_balance) as opening_balance,SUM(credit) as credit,\n" +
//                " (SUM(opening_balance) + SUM(credit)) as total\n" +
//                "FROM Accounts group by account_no", account_no);
//    }

}
