package controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Project;
import service.ProjectService;



public class ProjectController {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	private ProjectService projectService;
	
	public ProjectController() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.projectService = new ProjectService(manager);
	}



	public Project addNewProject(String name,String status,String outcome,String state,String streetAddress,String city,String country,Integer zipCode,Date startDate,Date endDate){
		Project project = new Project();
		project.setProjectName(name);
		project.setStatus(status);
		project.setStartDate(startDate!=null?new java.sql.Date(startDate.getTime()):null);
		project.setEndDate(endDate!=null?new java.sql.Date(endDate.getTime()):null);
		project.setStreetAddress(streetAddress);
		project.setCity(city);
		project.setCountry(country);
		project.setZipCode(zipCode);
		project.setOutcome(outcome);
		project.setState(state);
		Project P = projectService.addProject(project);
		System.out.println(P);
		return P;
	}
	
	public List<Project> getAllProjectList(){
		return projectService.getAllProjects();
	}
}
