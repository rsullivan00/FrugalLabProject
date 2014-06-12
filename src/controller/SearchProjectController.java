package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JDesktopPane;

import model.Project;
import model.ProjectFile;
import model.ProjectSummary;
import service.ProjectService;
import service.SearchProjectService;
import view.ProjectView;

/**
 * Created by Rick on 5/30/2014.
 */
public class SearchProjectController {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	private ProjectService projectService;
	private SearchProjectService searchProjectService;
	private JDesktopPane desktop;
	private ProjectView pv;
	
	public SearchProjectController(JDesktopPane dp) {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.projectService = new ProjectService(manager);
		this.searchProjectService = new SearchProjectService(manager);
		this.pv = new ProjectView(dp);
		this.desktop = dp;
	}

	public List<Project> searchProjectByName(String name){
		List<Project> projectList = searchProjectService.searchProjectByName(name);
		System.out.println("project name "+name);
		return projectList;
	}
	
	public List<Project> searchProjectByStatus(String status){
		List<Project> projectList = searchProjectService.searchProjectByStatus(status);
		System.out.println("project list size :"+projectList.size());
		return projectList;
	}
	
	public List<Project> searchProjectByDate(Date date ,boolean isStartDate){
		List<Project> projectList = searchProjectService.searchProjectByDate(new java.sql.Date(date.getTime()), isStartDate);
		System.out.println("project list size :"+projectList.size());
		return projectList;
	}
	
	public List<Project> searchProjectByParticipantName(String name){
		List<Project> projectList = searchProjectService.searchProjectByParticipantName(name);
		
		return projectList;
	}
	
	public List<Project> searchProjectByCategory(String name){
		List<Project> projectList = searchProjectService.searchProjectByCategory(name);
		
		return projectList;
	}
	
	public List<ProjectSummary> getProjectDistribution(){
		return searchProjectService.getProjectDistribution();
	}
	
	
}
