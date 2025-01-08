package com.altimetrik.controller;



import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.Entity.Employee;
import com.altimetrik.Entity.ProjectAllocation;
import com.altimetrik.service.ProjectAllocationService;

@RestController
@RequestMapping("/api/allocations")
@PreAuthorize("isAuthenticated()") 	
public class ProjectAllocationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectAllocationService.class);

	@Autowired
	private ProjectAllocationService allocationService;

	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<ProjectAllocation> createAllocation(@RequestBody ProjectAllocation allocation) {
		ProjectAllocation created = allocationService.createAllocation(allocation);
		return ResponseEntity.ok(created);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')") // Only users with ROLE_USER can update
	public ResponseEntity<ProjectAllocation> updateAllocation(@PathVariable Long id,
			@RequestBody ProjectAllocation allocation) {
		ProjectAllocation updated = allocationService.updateAllocation(id, allocation);
		return ResponseEntity.ok(updated);
	}
	
	@GetMapping("/{projectId}/second-most-experienced")
	public ResponseEntity<?> getSecondMostExperiencedEmployee(@PathVariable Long projectId) {
		logger.info("Received request to find second most experienced employee in project: {}", projectId);

		try {
			List<Employee> employee = allocationService.findSecondMostExperiencedInProject(projectId);

			if (employee.isEmpty()) {
				logger.warn("No second most experienced employee found for project: {}", projectId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project has fewer than 2 employees");
			}

			logger.info("Successfully retrieved second most experienced employee for project: {}", projectId);
			return ResponseEntity.ok(employee.get(0));

		} catch (ServiceException e) {
			logger.error("Error processing request: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving employee data");
		}
	}
	
	@GetMapping("/{employeeId}/primarySecondarySkillEmployee")
	public ResponseEntity<?> primarySecondarySkillEmployee(@PathVariable Long employeeId, @RequestParam String[] primarySkill, @RequestParam String[] secondarySkill) {
		logger.info("Received request to find second most experienced employee in project: {}", employeeId, primarySkill, secondarySkill);

		try {
			List<Employee> employee = allocationService.primarySecondarySkillEmployee(employeeId, primarySkill, secondarySkill);

			if (employee.isEmpty()) {
				logger.warn("No second most experienced employee found for project: {}", employeeId, primarySkill, secondarySkill);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project has fewer than 2 employees");
			}

			logger.info("Successfully retrieved second most experienced employee for project: {}", employeeId, primarySkill, secondarySkill);
			return ResponseEntity.ok(employee.get(0));

		} catch (ServiceException e) {
			logger.error("Error processing request: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving employee data");
		}
	}
	
	@GetMapping("/{projectId}/primarySkillEmployeeNotAllocated")
	public ResponseEntity<?> primarySkillEmployeeNotAllocated(@PathVariable Long employeeId, @RequestParam String[] primarySkill) {
		logger.info("Received request to find second most experienced employee in project: {}", employeeId, primarySkill);

		try {
			List<Employee> employee = allocationService.primarySecondarySkillEmployee(employeeId, primarySkill);

			if (employee.isEmpty()) {
				logger.warn("No second most experienced employee found for project: {}", employeeId, primarySkill);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project has fewer than 2 employees");
			}

			logger.info("Successfully retrieved second most experienced employee for project: {}", employeeId, primarySkill);
			return ResponseEntity.ok(employee.get(0));

		} catch (ServiceException e) {
			logger.error("Error processing request: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving employee data");
		}
	}


	@GetMapping
	public ResponseEntity<List<ProjectAllocation>> getAllAllocations() {
		List<ProjectAllocation> allocations = allocationService.getAllAllocations();
		return ResponseEntity.ok(allocations);
	}
}