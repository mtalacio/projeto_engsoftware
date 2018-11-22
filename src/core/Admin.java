package core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends Database {
	
	public Admin() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Id
	@GeneratedValue
	private int id;
	private String login;
	private String senha;
	
	public Admin(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	
}
