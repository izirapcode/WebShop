package iziPak.service;

import java.util.List;

import iziPak.entity.Account;

public interface AccountService {
	
	List<Account> getAccounts();
	
	void registerAccount(Account account);
	
	Account getAccount(String id);
	
	void deleteAccount(String id);

}
