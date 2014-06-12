package controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JDesktopPane;

import model.Category;
import model.Participant;
import model.Project;
import model.ProjectFile;
import service.FileService;
import service.ParticipantService;
import service.ProjectService;



public class ProjectController {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	private ProjectService projectService;
	private ParticipantService participantService;
	private FileService fileService;
	private JDesktopPane desktop;
	//private CategoryServ categoryService;
	
	public ProjectController(JDesktopPane dp) {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.projectService = new ProjectService(manager);
		this.fileService = new FileService(manager);
		this.desktop = dp;
	}
	public ProjectController(List<ProjectFile> fList,JDesktopPane dp) {
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		this.projectService = new ProjectService(manager);
		this.fileService = new FileService(manager);
		this.desktop = dp;
	}
	
	
	public Project addNewProject(String name,String status,String outcome,String state,String streetAddress,String city,String country,Integer zipCode,Date startDate,Date endDate,String dirPath,Set<String> fileNames,Set<Integer> participantIds,Set<Integer> categoryIds){
		try{
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
			project.setProjectLocation(dirPath);
			List<ProjectFile> projFiles = new ArrayList<ProjectFile>();
			for(String fname :fileNames){
				ProjectFile projFile = new ProjectFile();
				if(fname.startsWith("#")){
					projFile.setFileType("hyperlink");
					projFile.setFileName(fname.substring(1));
					
				}else{
					String[] fileArr = fname.split("\\.");
					System.out.println(fileArr.length);
					projFile.setFileType(fileArr[1]);
					projFile.setFileName(fname);
				}
	
				
				System.out.println("filename : "+fname);
				
				projFiles.add(projFile);
				
			}
			Set<Participant> participants = new HashSet<Participant>();
			for(Integer id :participantIds){
				System.out.println(id);
			}
			for(Integer id :participantIds){
				Participant participant = participantService.readParticipant(id);
				participants.add(participant);
				
			}
			Set<Category> categories = new HashSet<Category>();
			/*for(Integer id :categoryIds){
				Category projFile = categoryService.readCategory(id);
				categories.add(projFile);
				
			}*/
		
			Project P = projectService.addProject(project,projFiles,participants,categories);
			return P;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public Project updateProject(Integer projectId,String name,String status,String outcome,String state,String streetAddress,String city,String country,Integer zipCode,Date startDate,Date endDate,String dirPath,Set<String> fileNames,Set<Integer> deletedFileIds,Set<Integer> deletedParticipantIds,Set<Integer> newParticipantIds,Set<Integer> deletedCategory,Set<Integer> newCategoryIds){
		Project project = manager.find(Project.class, projectId);
		project.setProjectName(name);
		project.setStatus(status);
		if(startDate!=null){
			project.setStartDate(new java.sql.Date(startDate.getTime()));
		}
		if(endDate!=null){
			project.setEndDate(new java.sql.Date(endDate.getTime()));
		}
		
		project.setStreetAddress(streetAddress);
		project.setCity(city);
		project.setCountry(country);
		project.setZipCode(zipCode);
		project.setOutcome(outcome);
		project.setState(state);
		List<ProjectFile> dProjFiles = new ArrayList<ProjectFile>();
		List<ProjectFile> newProjFiles = new ArrayList<ProjectFile>();
		for(String fname :fileNames){
			ProjectFile projFile = new ProjectFile();
			if(fname.startsWith("#")){
				projFile.setFileType("hyperlink");
				projFile.setFileName(fname.substring(1));
				
			}else{
				String[] fileArr = fname.split("\\.");
				System.out.println(fileArr.length);
				projFile.setFileType(fileArr[1]);
				projFile.setFileName(fname);
			}
			projFile.setFilePath(project.getProjectLocation());
			newProjFiles.add(projFile);
			
		}
		
		for(Integer id :deletedFileIds){
			ProjectFile file = fileService.getFileById(id);
			dProjFiles.add(file);
		}
		
		Set<Participant> dParticipants = new HashSet<Participant>();
		Set<Participant> newParticipants = new HashSet<Participant>();
		/*for(Integer id :deletedParticipantIds){
			Participant participant = participantService.readParticipant(id);
			participants.add(participant);
		}
		
		for(Integer id :newParticipantIds){
			Participant participant = participantService.readParticipant(id);
			newParticipants.add(participant);
		}*/
		Set<Category> dCategories = new HashSet<Category>();
		Set<Category> newCategory = new HashSet<Category>();
		/*for(Integer id :deletedCategoryIds){
			Category category = categoryService.readCategory(id);
			categories.add(category);
		}
			for(Integer id :newCategoryIds){
			Category category = categoryService.readCategory(id);
			newCategory.add(category);
			
		}*/
		Project P = projectService.updateProject(project,dProjFiles,newProjFiles,dParticipants,newParticipants,dCategories,newCategory);
		System.out.println(P);
		return P;
	}
	
	public boolean isValidURL(String url){
   	 URL u = null;
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }
        try {
            u.toURI();
        } catch (URISyntaxException e) {
            return false;
        }
        return true;
   }
	
	public List<Project> getAllProjectList(){
		return projectService.getAllProjects();
	}
	
	public Project getProjectById(Integer projectId){
		return projectService.getProjectById(projectId);
	}
	
	public Project getProjectDetailsById(int projectId){
		return projectService.getProjectDetailsById(projectId);
	}
	
	public boolean deleteProjectById(int projectId){
		return projectService.deleteProjectById(projectId);
	}
	
	
}
