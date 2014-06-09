package service;

import model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.lang.String;
import java.util.List;

/**
 * service.ParticipantService.java
 * Created by Rick Sullivan on 5/27/2014.
 * COEN 160 Labs 7 and 8
 *
 * The service.ParticipantService manages changes to the participant table using the JPA.
 * Modified from R. Grover's CourseListService.
 */

// Jorge using Rick's code to model CategoryService
public class CategoryService {
	private EntityManager manager;

	public CategoryService(EntityManager manager) {
		 this.manager = manager;
	}
	 
    // method to create a new record
    public Category createCategory(String Category) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Category category = new Category();
 	    category.setCategoryName(Category);

 	    manager.persist(category);

        transaction.commit();
 	    return category;
    }
    
    // method to read a record
     public Category readCategory(int id) {
    	 Category category = manager.find(Category.class, id);
    	 return category;
     }

     // method to read all records
     public List<Category> readAll() {
    	 TypedQuery<Category> query = manager.createQuery("SELECT e FROM participant e", Category.class);
    	 List<Category> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public Category updateCategory(int id, String Category) {
         EntityTransaction transaction = manager.getTransaction();
         transaction.begin();
    	 Category category = manager.find(Category.class, id);
    	 if (category != null) {
    		 category.setId(id);
    		 category.setCategoryName(Category);

    	 }
         transaction.commit();
    	 return category;
     }

    // method to delete a record
    public void deleteCategory(int id) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
    	Category participant = manager.find(Category.class, id);
    	if (participant != null) {
    	    manager.remove(category);
    	}
        transaction.commit();
    }
}

