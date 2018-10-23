package iziPak.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class Account {

	@Id
	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="enabled")
	private boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true,mappedBy = "account")
	private List<Authority> authorities;


	@OneToMany(mappedBy = "account",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Order> orders;


	public List<Authority> getAuthorities() {
		return authorities;
	}

	public Account(){
	}

	public Account(String username){
		this.username = username;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String login) {
		this.username = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addAuthority(Authority authority){

		if(authorities == null)
			authorities = new LinkedList<>();
		authority.setAccount(this);
		authorities.add(authority);
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order){

		if(orders == null)
			orders = new HashSet<>();
		order.setAccount(this);
		orders.add(order);
	}
}
