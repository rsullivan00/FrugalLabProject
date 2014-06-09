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
public class SearchParticipantController implements TableModelListener {
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

    public Participant addParticipant(String firstName, String lastName, Role role, String photoURL) {
        return participantService.createParticipant(firstName, lastName, role, photoURL);
    }

    public void editParticipant() {

    }

    public List<Participant> getAllParticipants() {
        return participantService.readAll();
    }

    public void deleteParticipant(int id) {
        participantService.deleteParticipant(id);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getColumn() < 0)
            return;

        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            Participant p = view.getParticipantList().get(row);
            p = participantService.updateParticipant(p.getId(), p.getFirstName(), p.getLastName(), p.getRole(), p.getPhotoURL());
            view.getParticipantList().set(row, p);
        }
    }
}
