package com.vikram.springboot.PMSRESTAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//JPA ENTITY CLASS

@Entity	
@Table(name="projects")
public class Project {
	
	@Id
    @Column(name="project_id")
private String projectId;
	@Column(name="project_name")	
private String projectName;
	@Column(name="description")	
private String description;
	@Column(name="author_id")	
private String authorId;
	@Column(name="status")	
private int status;

public Project() {
	super();
}
public Project(long id, String projectId, String projectName, String description, String authorId, int status) {
	super();
	this.projectId = projectId;
	this.projectName = projectName;
	this.description = description;
	this.authorId = authorId;
	this.status = status;
}

public String getProjectId() {
	return projectId;
}


public void setProjectId(String projectId) {
	this.projectId = projectId;
}


public String getProjectName() {
	return projectName;
}


public void setProjectName(String projectName) {
	this.projectName = projectName;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getAuthorId() {
	return authorId;
}


public void setAuthorId(String authorId) {
	this.authorId = authorId;
}


public int getStatus() {
	return status;
}


public void setStatus(int status) {
	this.status = status;
}
}
