package service;

import model.Participant;

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

	public ParticipantService(EntityManager manager) {
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
    	 Participant participant = manager.find(Participant.class, id);
    	 return participant;
     }

     // method to read all records
     public List<Participant> readAll() {
    	 TypedQuery<Participant> query = manager.createQuery("SELECT e FROM participant e", Participant.class);
    	 List<Participant> result =  query.getResultList();

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

