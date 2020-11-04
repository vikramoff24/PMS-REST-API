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
	
	//Get All Employees
	
	@GetMapping("/projects")
	public List<Project> getAllEmployees()
	{
	return projectRepository.findAll();	
	}
	//Create Employee
	@PostMapping("/projects")
	public Project createEmployees(@Valid @RequestBody Project project)
	{
	return projectRepository.save(project);	
	}
	//Get Employee By Id
	@GetMapping("/projects/{id}")
	public ResponseEntity<Project> getEmployeeById(@PathVariable(value = "id") Long projectId)
			throws ResourceNotFoundException {
		Project employee = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
		return ResponseEntity.ok().body(employee);
	}
	
	//Update a Employee
	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> updateEmployee(@PathVariable(value = "id") Long projectId,
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
	//delete employee by id
		
		@DeleteMapping("/employees/{id}")
		public ResponseEntity deleteEmployee(@PathVariable(value = "id") Long employeeId)
				throws ResourceNotFoundException {
			employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

			employeeRepository.deleteById(employeeId);
//			Map<String, Boolean> response = new HashMap<>();
//			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok().build();
		}
	
	
	
}


public class ProjectController {

}
