package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Category;
import model.Participant;
import model.Project;
import model.ProjectFile;
import model.ProjectSummary;

public class ProjectService {
	private EntityManager manager;
	EntityTransaction transaction = null;
	private FileService fileService;
	private ParticipantService participantService;

	public ProjectService(EntityManager manager) {
		super();
		this.manager = manager;
		transaction = manager.getTransaction();
		this.fileService = fileService;
		this.participantService = participantService;
	}
	
	public Project getProjectById(int projectId){
		Project project = manager.find(Project.class, projectId);
		System.out.println("project files "+project.getProjectFiles());
		System.out.println("project participants "+project.getParticipants());
		return project;
	}
	
	public Project getProjectDetailsById(int projectId){
		try{
			TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p INNER JOIN FETCH p.participants pt INNER JOIN FETCH p.projectFiles f INNER JOIN FETCH p.categories c WHERE p.projectID = :pid",Project.class);
			query.setParameter("pid", projectId); 
			Project project = query.getResultList().get(0);
			//project.setProjectFiles(fileService.getAllFilesForProject(projectId));
			System.out.println(project.getProjectFiles().size());
			System.out.println(project.getParticipants().size());
			return project;
		}catch(Exception e){
			System.out.println(e.getStackTrace()+e.getMessage());
		}
		return null;
	}
	
	public List<Project> getAllProjects(){
		 TypedQuery<Project> query = manager.createQuery("SELECT p FROM project p", Project.class);
    	 List<Project> result =  query.getResultList();
		return result;
	}
	
	public Project addProject(Project project,List<ProjectFile> projFiles,Set<Participant> participants,Set<Category> categories){
		project.setCreationDate(new java.sql.Date(new Date().getTime()));
		try{
			transaction.begin();
			manager.persist(project);
			manager.flush();
			System.out.println(project.getProjectID());
			for(ProjectFile file :projFiles){
				file.setProjectID(project.getProjectID());
				file.setFilePath(project.getProjectLocation()+"\\" + project.getProjectName()+"_"+project.getProjectID());
				manager.persist(file);
			}
			/*for(Participant participant :participants){
				participant.setProjectID(project.getProjectID());
				manager.persist(participant);
			}
			for(Category category :categories){
				category.setProjectID(project.getProjectID());
				manager.persist(category);
			}*/
			project.setProjectLocation(project.getProjectLocation()+"\\" + project.getProjectName()+"_"+project.getProjectID());
			manager.persist(project);
			transaction.commit();
		}catch(Exception e){
			System.out.println(e.getStackTrace()+e.getMessage());
		}
		return project;
	}
	
	public Project updateProject(Project project,List<ProjectFile> dProjFiles,List<ProjectFile> newProjFiles,Set<Participant> dParticipants,Set<Participant> newParticipants,Set<Category> dCategories,Set<Category> newCategories){
		try{
			transaction.begin();
			manager.persist(project);
			System.out.println("project id :"+project.getProjectID());
			if(dProjFiles!=null){
				for(ProjectFile file :dProjFiles){
						manager.remove(file);
				}
			}
			if(newProjFiles!=null){
				for(ProjectFile file :newProjFiles){
						file.setProjectID(project.getProjectID());
						manager.persist(file);
				}
			}
			
			/*if(dParticipants!=null){
				for(Participant participant :dParticipants){
						manager.remove(participant);
				}
			}
			
			if(newParticipants!=null){
				for(Participant participant :newParticipants){
						participant.setProjectID(project.getProjectID());
						manager.persist(participant);
					}
				}
			}
			
			if(dCategories!=null){
				for(Category category :categories){
						manager.remove(category);s
				}
			}
			
			if(newCategories!=null){
				for(Category category :newCategories){
						category.setProjectID(project.getProjectID());
						manager.persist(category);
					}
				}
			}*/
			
			transaction.commit();
		}catch(Exception e){
			System.out.println(e.getStackTrace()+e.getMessage());
		}
		return project;
	}
	
	public boolean deleteProjectById(int projectId){
		Project project = manager.find(Project.class, projectId);
		try{
			transaction.begin();
			manager.remove(project);
			transaction.commit();
			
		}catch(Exception e){
			manager.getTransaction().rollback();
			System.out.println(e.getStackTrace()+e.getMessage());
			return false;
		}
		return true;
	}
	
	

	
}
