package controller;

import model.Category;
import service.CategoryService;
import view.CategoryView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Created by Jorge
 */
public class CategoryController implements TableModelListener {
    private CategoryView view;
 	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private ParticipantService participantService;

	public CategoryController(CategoryView view) {
        this.view = view;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.entityManager = entityManagerFactory.createEntityManager();
		this.participantService = new ParticipantService(entityManager) ;
	}

    public Participant addCategory(String Category) {
        return CategoryService.createParticipant(Category);
    }

    public void editParticipant() {

    }

    public void deleteCategory(int id) {
        CategoryService.deleteCategory(id);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getColumn() < 0)
            return;

        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            Participant p = view.CategoryList.get(row);
            p = participantService.updateParticipant(p.getId(), p.getFirstName(), p.getLastName(), p.getRole(), p.getPhotoURL());
            view.participantList.set(row, p);
        }
    }
}
