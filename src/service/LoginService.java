package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Login;



public class LoginService {
	private EntityManager manager;

	public LoginService(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	public Login getUserLogin(String username){
		Login login = manager.find(Login.class, username);
		return login;
	}
	

}
