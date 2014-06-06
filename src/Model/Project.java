package model;

import javax.persistence.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity(name = "project")
public class Project implements Serializable {
   public static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

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

   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 11;
   }

   // return the data in column i
   public String getColumnData(int i) throws Exception {
       switch(i) {
           case(0): return Integer.toString(getProjectID());
           case(1): return getProjectName();
           case(2): return getOutcome();
           case(3): return getStatus();
           case(4): return getState();
           case(5): return getCountry();
           case(6): return getStreetAddress();
           case(7): return Integer.toString(getZipCode());
           case(8):
               return dateFormat.format(getStartDate());
           case(9):
               return dateFormat.format(getEndDate());
           case(10):
               return dateFormat.format(getCreationDate());
           default:
               throw new Exception("Error: invalid column index in participants table");
       }
   }

   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
       switch (i) {
           case(1): colName = "project_id";
                    break;
           case(2): colName = "name";
                    break;
           case(3): colName = "outcome";
                    break;
           case(4): colName = "status" ;
                    break;
           case(5): colName = "state";
                    break;
           case(6): colName = "country";
                    break;
           case(7): colName = "street_address";
                    break;
           case(8): colName = "zip";
                    break;
           case(9): colName = "start_date";
                    break;
           case(10): colName = "end_date";
                    break;
           case(11): colName = "creation_Date";
                    break;
           default:
               throw new Exception("Access to invalid column number in project table");
       }

	   return colName;
   }

   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
       switch (i) {
           case (1):
               setProjectID(Integer.parseInt((String) value));
               break;
           case (2):
               setProjectName((String) value);
               break;
           case (3):
               setOutcome((String) value);
               break;
           case (4):
               setStatus((String) value);
               break;
           case (5):
               setState((String) value);
               break;
           case (6):
               setCountry((String) value);
               break;
           case (7):
               setStreetAddress((String) value);
               break;
           case (8):
               setZipCode(Integer.parseInt((String) value));
               break;
           case (9):
               setStartDate(dateFormat.parse((String) value));
               break;
           case (10):
               setEndDate(dateFormat.parse((String) value));
               break;
           case (11):
               setCreationDate(dateFormat.parse((String) value));
               break;
           default:
               throw new Exception("Access to invalid column number in project table");
       }
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
}
