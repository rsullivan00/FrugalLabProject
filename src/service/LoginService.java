package service;

import javax.persistence.EntityManager;

import model.Login;



public class LoginService {
	private EntityManager manager;

	public LoginService(EntityManager manager) {
		this.manager = manager;
	}
	
	public Login getUserLogin(String username){
		Login login = manager.find(Login.class, username);
		return login;
	}
	

}
