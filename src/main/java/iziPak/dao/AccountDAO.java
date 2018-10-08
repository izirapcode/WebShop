package iziPak.dao;

import java.util.List;

import iziPak.entity.Account;

public interface AccountDAO {

	 List<Account> getAccounts();

	 void registerAccount(Account account);

	 Account getAccount(String id);

	 void deleteAccount(String id);

}
