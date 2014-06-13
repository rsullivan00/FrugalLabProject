package service;

import model.Role;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * service.RoleService.java
 * Created by Rick Sullivan on 5/27/2014.
 *
 * The service.roleService manages querying the role table using the JPA.
 * Modified from R. Grover's CourseListService.
 */
public class RoleService {
 	private EntityManager manager;

	public RoleService(EntityManager manager) {
		 this.manager = manager;
	}

    // method to read a record
     public Role readRole(int id) {
    	 Role role = manager.find(Role.class, id);
    	 return role;
     }

     // method to read all records
     public List<Role> readAll() {
    	 TypedQuery<Role> query = manager.createQuery("SELECT e FROM role e", Role.class);
    	 List<Role> result =  query.getResultList();

    	 return result;
     }
}
