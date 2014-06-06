package controller;

import model.Participant;
import service.ParticipantService;
import view.ParticipantView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Created by Rick on 5/30/2014.
 */
public class ParticipantController implements TableModelListener {
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

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getColumn() < 0)
            return;

        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            Participant p = view.participantList.get(row);
            p = participantService.updateParticipant(p.getId(), p.getFirstName(), p.getLastName(), p.getRole(), p.getPhotoURL());
            view.participantList.set(row, p);
        }
    }
}
