package service;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Project;
import model.ProjectFile;
import model.ProjectSummary;

public class SearchProjectService {
	private EntityManager manager;
	EntityTransaction transaction = null;

	public SearchProjectService(EntityManager manager) {
		super();
		this.manager = manager;
		transaction = manager.getTransaction();
	}
	
	public List<Project> searchProjectByStatus(String status){
		TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p WHERE p.status = :pstatus",Project.class);
		query.setParameter("pstatus", status); 
		List<Project> projectList = query.getResultList(); 
		return projectList;
	}
	
	public List<Project> searchProjectByName(String name){
		TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p WHERE p.projectName LIKE :pname",Project.class);
		query.setParameter("pname", "%"+name+"%"); 
		List<Project> projectList = query.getResultList(); 
		return projectList;
	}
	
	public List<Project> searchProjectByDate(Date date,boolean isStartDate){
		TypedQuery<Project> query = null;
		if(isStartDate){
			query = manager.createQuery("SELECT p FROM project p WHERE p.startDate = :pdate",Project.class);
		}else{
			query = manager.createQuery("SELECT p FROM project p WHERE p.endDate = :pdate",Project.class);
		}
		query.setParameter("pdate", date); 
		List<Project> projectList = query.getResultList(); 
		return projectList;
	}
	public List<Project> searchProjectByParticipantName(String name){
		TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p JOIN FETCH p.participants pt WHERE pt.firstName LIKE :name OR pt.lastName LIKE :name",Project.class);
		query.setParameter("name", "%"+name+"%"); 
		List<Project> projectList = query.getResultList(); 
		return projectList;
	}
	
	public List<Project> searchProjectByCategory(String name){
		TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p WHERE p.categories c WHERE c.name LIKE :name",Project.class);
		query.setParameter("name", name); 
		List<Project> projectList = query.getResultList(); 
		return projectList;
	}
	
	public List<ProjectSummary> getProjectDistribution(){
		try{
			TypedQuery<ProjectSummary> query = manager.createQuery("SELECT p FROM total_project_summary p",ProjectSummary.class);
			List<ProjectSummary> summary = query.getResultList(); 
			return summary;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
}
