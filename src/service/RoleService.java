package service;

import model.Role;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Rick on 6/9/2014.
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
