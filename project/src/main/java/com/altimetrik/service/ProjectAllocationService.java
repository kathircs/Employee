package com.altimetrik.service;

import java.util.List;

import com.altimetrik.Entity.Employee;
import com.altimetrik.Entity.ProjectAllocation;

public interface ProjectAllocationService {

	public ProjectAllocation createAllocation(ProjectAllocation allocation);

	public ProjectAllocation updateAllocation(Long id, ProjectAllocation allocation);

	public List<ProjectAllocation> getAllAllocations();
	
	public List<Employee> findSecondMostExperiencedInProject(Long projectId);
	
	public List<Employee> primarySecondarySkillEmployee(Long employeeId, String[] primarySkill, String[] secondarySkill);
	
	public List<Employee> primarySecondarySkillEmployee(Long employeeId, String[] primarySkill);

}
