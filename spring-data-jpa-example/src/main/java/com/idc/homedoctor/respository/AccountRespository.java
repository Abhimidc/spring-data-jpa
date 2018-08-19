package com.idc.homedoctor.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idc.homedoctor.model.Account;


public interface AccountRespository extends CrudRepository<Account,Integer>
{
Account findAccountById(int id);
Account findAccountByName(String name);
Account findAccountByBalance(int balance);



}
