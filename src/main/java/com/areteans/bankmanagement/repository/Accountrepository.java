package com.areteans.bankmanagement.repository;


import com.areteans.bankmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Accountrepository extends JpaRepository <Account,Long>{
}
