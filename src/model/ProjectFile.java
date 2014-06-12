package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "files")
public class ProjectFile {
    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileID;

    @Column(name = "file_path")
    private String filePath;
    
    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "file_type")
    private String fileType;
    
    @Column(name = "project_id")
    private Integer projectID;
    
    @ManyToOne(cascade=CascadeType.MERGE)
	@PrimaryKeyJoinColumn(name="project_id")
	private Project project;


   public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

public Integer getFileID() {
		return fileID;
	}

	public void setFileID(Integer fileID) {
		this.fileID = fileID;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	

public ProjectFile() {
		super();
	}

public ProjectFile(Integer fileID, String filePath, String fileName,
			String fileType, Integer projectID) {
		super();
		this.fileID = fileID;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileType = fileType;
		this.projectID = projectID;
	}

// return number of columns in the table
   public int getNumberOfColumns() {
	   return 4;
   }

   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getFileID().toString();
	   else if (i == 1)
		   return getFilePath();
	   else if (i == 2)
		   return getFileName();
	   else if (i == 3)
		   return getFileType();
	   else
		   throw new Exception("Error: invalid column index in login table");
   }

   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0)
		   colName = "file_id";
	   else if (i == 1)
		   colName = "File Path";
	   else if (i == 2)
		   colName = "File Name";
	   else if (i == 3)
		   colName = "File Type";
	   else
		   throw new Exception("Access to invalid column number in file table");

	   return colName;
   }

   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0)
		   fileID = (Integer)value;
	   else if (i == 1)
		   filePath = (String) value;
	   else if (i == 2)
		   fileName = (String) value;
	   else if (i == 1)
		   fileType = (String) value;
	   else
		   throw new Exception("Error: invalid column index in file table");
   }

}
