package controller;

import model.Participant;
import service.ParticipantService;
import view.ParticipantView;
import view.SearchParticipantView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Created by Rick on 5/30/2014.
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

    public void editParticipant() {

    }

    public void deleteParticipant(int id) {
        participantService.deleteParticipant(id);
    }
}
