package controller;

import model.Role;
import service.RoleService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Rick on 6/9/2014.
 */
public class RoleController {
 	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private RoleService roleService;

	public RoleController() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.entityManager = entityManagerFactory.createEntityManager();
		this.roleService = new RoleService(entityManager) ;
	}

    public Role getRole(int id) {
        return roleService.readRole(id);
    }

    public List<Role> getAllRoles() {
        return roleService.readAll();
    }
}
