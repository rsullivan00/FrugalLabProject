package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


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
	
	@Column(name = "project_location")
	private String projectLocation;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="project",fetch = FetchType.EAGER)
	   private List<ProjectFile> projectFiles;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="project_participants", 
	   joinColumns = @JoinColumn(name="project_id"),
	   inverseJoinColumns = @JoinColumn(name="participant_id"))
	private Set<Participant> participants;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="project_category", 
	   joinColumns = @JoinColumn(name="project_id"),
	   inverseJoinColumns = @JoinColumn(name="category_id"))
	private Set<Category> categories;
	
	
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

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
	
	
	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public List<ProjectFile> getProjectFiles() {
		return projectFiles;
	}

	public void setProjectFiles(List<ProjectFile> projectFiles) {
		this.projectFiles = projectFiles;
	}
	
	
	  public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	// return number of columns in the table
	   public int getNumberOfColumns() {
		   return 6;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 1)
			   return getProjectName();
		   else if (i == 2)
			   return getStatus();
		   else if (i == 3) 
			   return getStartDate().toString();
		   else if (i == 4)
			   return getEndDate().toString();
		   else if (i == 5)
			   return getCountry();
		   else if (i == 0)
			   return Integer.toString(getProjectID());
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 1) 
			   colName = "Name";
		   else if (i == 2)
			   colName = "Status";
		   else if (i == 3)
			   colName = "Start Date";
		   else if (i == 4)
			   colName = "End Date";
		   else if (i == 5)
			   colName = "Location";
		   else if (i == 0)
			   colName = "Project ID";
		   else 
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   projectID = (Integer) value;
		   else if (i == 1) 
			   projectName = (String) value;
		   else if (i == 2) 
			   status = (String) value;
		   else if (i == 3) 
			   startDate =  Date.valueOf(((String) value));
		   else if (i == 4)
			   endDate = Date.valueOf((String) value);
		   else if (i == 5)
			  country = (String) value;
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
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
