package service;

import model.Participant;
import model.Project;
import model.Role;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

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
public class ParticipantService {
	private EntityManager manager;
    private RoleService roleService;

	public ParticipantService(EntityManager manager) {
        this.roleService = new RoleService(manager);
		 this.manager = manager;
	}
	 
    // method to create a new record
    public Participant createParticipant(String firstName, String lastName, int role, String photoURL) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Participant participant = new Participant();
 	    participant.setFirstName(firstName);
 	    participant.setLastName(lastName);
 	    participant.setRole(role);
        participant.setPhotoURL(photoURL);
 	    manager.persist(participant);

        transaction.commit();
 	    return participant;
    }
    
    // method to read a record
     public Participant readParticipant(int id) {
    	 try{
	    	 TypedQuery<Participant> query = manager.createQuery("SELECT p FROM participant p WHERE p.id = :pid",Participant.class);
	    	 query.setParameter("pid", id); 
	    	 Participant participant = query.getResultList().get(0);
             Role r = roleService.readRole(participant.getRole());
             if (r != null) {
                 participant.setRoleName(r.getName());
             }
	    	 return participant;
    	 }catch(Exception e){
    		 
    	 }
    	 return null;
     }

     // method to read all records
     public List<Participant> readAll() {
         /* Query while ignoring cache to always get new data */
    	 TypedQuery<Participant> query = manager.createQuery("SELECT e FROM participant e", Participant.class).setHint(QueryHints.REFRESH, HintValues.TRUE);
    	 List<Participant> result =  query.getResultList();
         for (Participant p: result) {
             Role r = roleService.readRole(p.getRole());
             if (r != null) {
                 p.setRoleName(r.getName());
             }
         }

    	 return result;   	 
     }
     
    // method to update a record
     public Participant updateParticipant(int id, String firstName, String lastName, int role, String photoURL) {
         EntityTransaction transaction = manager.getTransaction();
         transaction.begin();
    	 Participant participant = manager.find(Participant.class, id);
    	 if (participant != null) {
    		 participant.setId(id);
    		 participant.setFirstName(firstName);
    		 participant.setLastName(lastName);
    		 participant.setRole(role);
             participant.setPhotoURL(photoURL);
    	 }
         transaction.commit();
    	 return participant;
     }

    // method to delete a record
    public void deleteParticipant(int id) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
    	Participant participant = manager.find(Participant.class, id);
    	if (participant != null) {
    	    manager.remove(participant);
    	}
        transaction.commit();
    }
}

