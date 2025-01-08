package com.altimetrik.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.Entity.Employee;
import com.altimetrik.Entity.ProjectAllocation;
import com.altimetrik.repository.EmployeeRepository;
import com.altimetrik.repository.ProjectAllocationRepository;
import com.altimetrik.repository.ProjectRepository;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
	@Autowired
	private ProjectAllocationRepository allocationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public ProjectAllocation createAllocation(ProjectAllocation allocation) {
		return allocationRepository.save(allocation);
	}

	public ProjectAllocation updateAllocation(Long id, ProjectAllocation allocation) {
		ProjectAllocation existing = allocationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Allocation not found"));

		/*
		 * existing.setEmployee(allocation.getEmployee());
		 * existing.setProject(allocation.getProject());
		 * existing.setRole(allocation.getRole());
		 * existing.setStartDate(allocation.getStartDate());
		 */

		return allocationRepository.save(existing);
	}

	public List<ProjectAllocation> getAllAllocations() {
		return allocationRepository.findAll();
	}
	
	
	public List<Employee> findSecondMostExperiencedInProject(Long projectId) {
		try {
			List<Employee> employees = employeeRepository.findSecondMostExperiencedInProject(projectId);
			return employees;
		} catch (Exception e) {
			throw new ServiceException("Error retrieving employee data", e);
		}
	}
	
	public List<Employee> primarySecondarySkillEmployee(Long employeeId, String[] primarySkill, String[] secondarySkill)
	{

		try {
			List<Employee> employees = employeeRepository.primarySecondarySkillEmployee(employeeId, primarySkill, secondarySkill);
			return employees;
		} catch (Exception e) {
			throw new ServiceException("Error retrieving employee data", e);
		}
	
	}
	
	public List<Employee> primarySecondarySkillEmployee(Long employeeId, String[] primarySkill)
	{

		try {
			List<Employee> employees = employeeRepository.primarySecondarySkillEmployee(employeeId, primarySkill);
			return employees;
		} catch (Exception e) {
			throw new ServiceException("Error retrieving employee data", e);
		}

	}
}