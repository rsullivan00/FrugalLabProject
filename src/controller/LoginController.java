package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Login;
import service.LoginService;

/**
 * Created by Rick on 5/30/2014.
 */
public class LoginController {
	private EntityManagerFactory emf;
	private EntityManager manager;
	private LoginService loginService;
	
	public LoginController() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.loginService = new LoginService(manager) ;
	}

	
	
	public boolean validateUser(String username,String password){
		System.out.println(username);
		System.out.println(password);
		Login login = loginService.getUserLogin(username);
		System.out.println(login);
		if(login!=null){
			return login.getPassword().equals(password);
		}
		return false;
	}
}
