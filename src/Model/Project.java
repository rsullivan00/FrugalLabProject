package Model;

import javax.persistence.*;

import java.io.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "project")
public class Project implements Serializable {

  @Id
  @Column(name = "project_id")
  @GeneratedValue(strategy = GenerationType.TABLE)
  private int projectID;
  
  @Column(name = "name")
  private String projectName;
  
  @Column(name = "status")
  private String status;

  @Column(name = "outcome")
  private String outcome;
  
  @Column(name = "state")
  private String state;
  
  @Column(name = "country")
  private String country;
  
  @Column(name = "street_address")
  private String streetAddress;
  
  @Column(name = "zip")
  private int zipCode;
  
  @Column(name = "start_date")
  private Date startDate;
  
  @Column(name = "end_date")
  private Date endDate;
  
  @Column(name = "creation_date")
  private Date creationDate;
  
  @ManyToMany(cascade=CascadeType.ALL, mappedBy="projects")
  private Set<Participant> projectParticipants;
  
  


	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getOutcome() {
		return outcome;
	}
	
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	

	public Set<Participant> getProjectParticipants() {
		return projectParticipants;
	}
	
	
	public void setProjectParticipants(Set<Participant> projectParticipants) {
		this.projectParticipants = projectParticipants;
	}
	

	@Override
	public String toString() {
	    return "Project{" +
	        "id=" + projectID +
	        ", name='" + projectName + '\'' +
	        ", status='" + status + '\'' +
	        ", startDate=" + startDate.toString() +
	        ", endDate=" + endDate.toString() +
	        '}';
	}

    
    
}
