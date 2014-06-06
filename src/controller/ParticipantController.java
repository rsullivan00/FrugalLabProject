package controller;

import service.LoginService;
import service.ParticipantService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Rick on 5/30/2014.
 */
public class ParticipantController {
 	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private ParticipantService participantService;

	public ParticipantController() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("Participant");;
		this.entityManager = entityManagerFactory.createEntityManager();
		this.participantService = new ParticipantService(entityManager) ;
	}
}
