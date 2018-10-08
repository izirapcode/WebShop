package iziPak.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import iziPak.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDAO {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	
	
	@Override
	public List<Account> getAccounts() {


		Session session = sessionFactory.getObject().getCurrentSession();
		 return  session.createQuery("from Account",Account.class).getResultList();
		
	}

	@Override
	public void registerAccount(Account account) {

		Session session = sessionFactory.getObject().getCurrentSession();
		session.saveOrUpdate(account);

	}

	@Override
	public Account getAccount(String id) {
		
		Session session = sessionFactory.getObject().getCurrentSession();
		return session.get(Account.class, id);
	}


	@Override
	public void deleteAccount(String id) {
		Session session = sessionFactory.getObject().getCurrentSession();
		session.delete(session.get(Account.class,id));
	}

}
