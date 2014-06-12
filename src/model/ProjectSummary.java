package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by Rick on 5/30/2014.
 */
@Entity(name = "total_project_summary")
public class ProjectSummary implements Serializable {
	@Id
	@Column(name = "status")
	private String status;
  
	@Column(name = "percentage")
	private Double percentage;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	
}
