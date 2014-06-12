package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import service.FileService;
import model.ProjectFile;

/**
 * Created by Rick on 5/30/2014.
 */
public class FileController {
	private EntityManagerFactory emf;
	private EntityManager manager;
	EntityTransaction transaction = null;
	private FileService fileService;

	public FileController() {
		super();
		this.emf = Persistence.createEntityManagerFactory("PersistenceUnit");;
		this.manager = emf.createEntityManager();
		transaction = manager.getTransaction();
		this.fileService = new FileService(manager);
	}
	
	public ProjectFile getFileById(int fileId){
		return fileService.getFileById(fileId);
	}
	
	public List<ProjectFile> getAllFilesForProject(int projectId){
		return fileService.getAllFilesForProject(projectId);
	}
	
	public boolean deleteFileById(int fileId){
		return fileService.deleteFileById(fileId);
	}
}
