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
	private CategoryService categoryService;
	public CategoryController(CategoryView view) {
        this.view = view;
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.entityManager = entityManagerFactory.createEntityManager();
		this.categoryService = new CategoryService(entityManager) ;
	}

    public Category addCategory(String Category) {
        return categoryService.createCategory(Category);
       
    }

    public void editCategory() {

    }

    public void deleteCategory(int id) {
       // CategoryService.deleteCategory(id);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getColumn() < 0)
            return;

        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            Category c = view.CategoryList.get(row);
            Category c = view.
            //c = categoryService.updateCategory(c.getId(), c.getCategoryName());
            //view.CategoryList.set(row, c);
        }
    }
}
