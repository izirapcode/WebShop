package iziPak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iziPak.dao.AccountDAO;
import iziPak.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDao;
	
	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDao.getAccounts();
	}

	@Override
	@Transactional
	public void registerAccount(Account account) {
		
		accountDao.registerAccount(account);	
	
	}

	@Override
	@Transactional
	public Account getAccount(String id) {
		
		return accountDao.getAccount(id);
	}

	@Override
	@Transactional
	public void deleteAccount(String id) {
		
		accountDao.deleteAccount(id);
		
	}

}
