package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Category;
import service.CategoryService;
import view.CategoryView;



public class CategoryController {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	private CategoryService CategoryService;
	
	public CategoryController() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.CategoryService = new CategoryService(manager);
	}

	
	
	public Category addNewCategory(String name){
		Category Category = new Category();
		Category.setCategoryName(name);
		Category C = CategoryService.createCategory(name);
		System.out.println(C);
		return C;
	}
	
	public List<Category> getAllCategoryList(){
		return CategoryService.readAll();
	}
}
