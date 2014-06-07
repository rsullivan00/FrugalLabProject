package service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Participant;
import model.Project;

public class ProjectService {
	private EntityManager manager;
	EntityTransaction transaction = null;

	public ProjectService(EntityManager manager) {
		super();
		this.manager = manager;
		transaction = manager.getTransaction();
	}
	
	public Project getProjectById(int projectId){
		Project project = manager.find(Project.class, projectId);
		return project;
	}
	
	public List<Project> getAllProjects(){
		 TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p", Project.class);
    	 List<Project> result =  query.getResultList();
		return result;
	}
	
	public Project addProject(Project project){
		project.setCreationDate(new java.sql.Date(new Date().getTime()));
		try{
			transaction.begin();
			manager.persist(project);
			transaction.commit();
		}catch(Exception e){
			System.out.println(e.getStackTrace()+e.getMessage());
		}
		return project;
	}
}
