package com.vikram.springboot.PMSRESTAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.springboot.PMSRESTAPI.exception.ResourceNotFoundException;
import com.vikram.springboot.PMSRESTAPI.model.Project;
import com.vikram.springboot.PMSRESTAPI.repository.ProjectRepository;



@RestController 
@RequestMapping("/api/v1")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	//Get All project
	
	@GetMapping("/projects")
	public List<Project> getAllProjects()
	{
	return projectRepository.findAll();	
	}
	//Create  project
	@PostMapping("/projects")
	public Project createProjects(@Valid @RequestBody Project project)
	{
	return projectRepository.save(project);	
	}
	//Get project By Id
	@GetMapping("/projects/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable(value = "projectId") Long projectId)
			throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
		return ResponseEntity.ok().body(project);
	}
	
	//Update a  project
	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable(value = "projectId") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Projct not found for this id :: " + projectId));

		project.setProjectName(projectDetails.getProjectName());
		project.setDescription(projectDetails.getDescription());
		project.setAuthorId(projectDetails.getAuthorId());
		project.setStatus(projectDetails.getStatus());
		final Project updatedProject = projectRepository.save(project);
		return ResponseEntity.ok(updatedProject);
	}
	//delete project by id
		
		@DeleteMapping("/projects/{id}")
		public ResponseEntity deleteProject(@PathVariable(value = "projectId") Long projectId)
				throws ResourceNotFoundException {
			projectRepository.findById(projectId)
					.orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

			projectRepository.deleteById(projectId);
//			Map<String, Boolean> response = new HashMap<>();
//			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok().build();
		}
	
	
	
}


