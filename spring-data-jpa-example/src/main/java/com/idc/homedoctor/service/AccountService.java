package com.idc.homedoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idc.homedoctor.model.Account;
import com.idc.homedoctor.respository.AccountRespository;

@Service
public class AccountService
{
	AccountRespository accountRespository;

	@Autowired
	public void setAccountRespository(AccountRespository accountRespository) {
		this.accountRespository = accountRespository;
	}

@Transactional
public void transfer()
{
	//Account account=accountRespository.findAccountById(1000);
	Account account=new Account();
	account.setId(65000);
	account.setName("Abhi");
	account.setBalance(5000);
	accountRespository.save(account);
	//Account acc=accountRespository.findOne(1000);
	//accountRespository.delete(acc);
	
	//Account account=accountRespository.findAccountByName("Kumar");
	System.out.println(accountRespository.findAll());
	//System.out.println(accountRespository.findOne(1000));
	
}
@Transactional
public Account findWithPK(int id)
{
return accountRespository.findOne(id);	
}
@Transactional
public void save(Account account)
{
	 accountRespository.save(account);
}
	
	
}
