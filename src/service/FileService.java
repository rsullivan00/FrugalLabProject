package service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Category;
import model.Participant;
import model.Project;
import model.ProjectFile;

public class FileService {
	private EntityManager manager;
	EntityTransaction transaction = null;

	public FileService(EntityManager manager) {
		super();
		this.manager = manager;
		transaction = manager.getTransaction();
	}
	
	public ProjectFile getFileById(int fileId){
		ProjectFile projectFile = manager.find(ProjectFile.class, fileId);
		return projectFile;
	}
	
	public List<ProjectFile> getAllFilesForProject(int projectId){
		try{
			TypedQuery<ProjectFile> query = manager.createQuery("SELECT f FROM project p JOIN p.projectFiles f where p.projectID = :pid",ProjectFile.class);
			query.setParameter("pid", projectId);
			List<ProjectFile> fileList = query.getResultList();
			System.out.println(fileList!=null?fileList.size():0);
			return fileList;
		}catch(Exception e){
			System.out.println(e.getStackTrace()+e.getMessage());
			return null;
		}
	}
	
	public boolean deleteFileById(int fileId){
		ProjectFile projectFile = manager.find(ProjectFile.class, fileId);
		try{
			transaction.begin();
			manager.remove(projectFile);
			transaction.commit();
			
		}catch(Exception e){
			manager.getTransaction().rollback();
			System.out.println(e.getStackTrace()+e.getMessage());
			return false;
		}
		return true;
	}
}
