package iziPak.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

	public void add(Authority authority){

		if(authorities == null)
			authorities = new LinkedList<>();
		authority.setAccount(this);
		authorities.add(authority);
	}

}
