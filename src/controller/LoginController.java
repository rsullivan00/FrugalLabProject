package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Login;
import service.LoginService;

/**
 * Created by Rick on 5/30/2014.
 */
public class LoginController {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private LoginService loginService;
	
	public LoginController() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.entityManager = entityManagerFactory.createEntityManager();
		this.loginService = new LoginService(entityManager);
	}

	public boolean validateUser(String username,String password){
		System.out.println(username);
		Login login = loginService.getUserLogin(username);
		System.out.println(login);
		if(login!=null){
			return login.getPassword().equals(password);
		}
		return false;
	}
}
