package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Category;
import service.CategoryService;


public class CategoryController {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	private CategoryService categoryService;
	
	public CategoryController() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.categoryService = new CategoryService(manager);
	}


    public void deleteCategory(int id) {
        categoryService.deleteCategory(id);
    }
	
	public Category addNewCategory(String name){
		Category Category = new Category();
		Category.setCategoryName(name);
		Category C = categoryService.createCategory(name);
		System.out.println(C);
		return C;
	}
	
	public List<Category> getAllCategoryList(){
		return categoryService.readAll();
	}
}
