package controller;

import model.Participant;
import model.Role;
import service.ParticipantService;
import view.ParticipantView;
import view.SearchParticipantView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.List;

/**
 *  ParticipantController.java
 *  Created by Rick Sullivan on 5/27/2014.
 *
 *  The ParticipantController queries the ParticipantService to manage an individual Participant.
 *
 */
public class ParticipantController {
    private ParticipantView view;
 	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private ParticipantService participantService;

	public ParticipantController(ParticipantView view) {
        this.view = view;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.entityManager = entityManagerFactory.createEntityManager();
		this.participantService = new ParticipantService(entityManager) ;
	}

    public Participant addParticipant(String firstName, String lastName, int role, String photoURL) {
        return participantService.createParticipant(firstName, lastName, role, photoURL);
    }

    public Participant editParticipant(int id, String firstName, String lastName, int role, String photoURL) {
        return participantService.updateParticipant(id, firstName, lastName, role, photoURL);
    }

    public Participant getParticipant(int id) {
        return participantService.readParticipant(id);
    }

    public void deleteParticipant(int id) {
        participantService.deleteParticipant(id);
    }

    public List<Participant> getAllParticipants() {
        return participantService.readAll();
    }
}
