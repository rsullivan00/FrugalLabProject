package controller;

import model.Participant;
import model.Role;
import service.ParticipantService;
import view.SearchParticipantView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.List;

/**
 * Created by Rick on 6/8/2014.
 */
public class SearchParticipantController {
    private SearchParticipantView view;
 	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private ParticipantService participantService;

	public SearchParticipantController(SearchParticipantView view) {
        this.view = view;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
		this.entityManager = entityManagerFactory.createEntityManager();
		this.participantService = new ParticipantService(entityManager) ;
	}

    public List<Participant> getAllParticipants() {
        return participantService.readAll();
    }

    public Participant getParticipant(int id) {
        return participantService.readParticipant(id);
    }

    public void deleteParticipant(int id) {
        participantService.deleteParticipant(id);
    }
}
