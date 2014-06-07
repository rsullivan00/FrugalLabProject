package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by Rick on 5/30/2014.
 */
@Entity(name = "project")
public class Project implements Serializable {
	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
  
	@Column(name = "city")
	private String city;
  
	@Column(name = "street_address")
	private String streetAddress;
  
	@Column(name = "zip")
	private Integer zipCode;
  
	@Column(name = "start_date")
	private Date startDate;
  
	@Column(name = "end_date")
	private Date endDate;
  
	@Column(name = "creation_date")
	private Date creationDate;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
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
	
	public Project(){}
	public Project(int projectID,String projectName, String status, String outcome,
			String state, String country, String city, String streetAddress,
			int zipCode, Date startDate, Date endDate, Date creationDate) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.status = status;
		this.outcome = outcome;
		this.state = state;
		this.country = country;
		this.city = city;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
	}

	

}
