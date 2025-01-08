package com.altimetrik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.altimetrik.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "SELECT e.* FROM employees e JOIN project_employees pe ON e.id = pe.employee_id WHERE pe.project_id = :projectId ORDER BY e.overallExperiencer DESC LIMIT 1 OFFSET 1", nativeQuery = true)
	List<Employee> findSecondMostExperiencedInProject(@Param("projectId") Long projectId);

	@Query(value = "SELECT es FROM employees es WHERE es.employee.id = :employeeId AND es.primarySkill IN :primarySkill and es.secondarySkill IN :secondarySkill", nativeQuery = true)
	List<Employee> primarySecondarySkillEmployee(@Param("projectId") Long employeeId,
			@Param("primarySkill") String[] primarySkill, @Param("secondarySkill") String[] secondarySkill);
	
	@Query(value = "SELECT es FROM employees es WHERE es.employee.id = :employeeId AND es.primarySkill IN :primarySkill and es.allocation > 0", nativeQuery = true)
	List<Employee> primarySecondarySkillEmployee(@Param("projectId") Long employeeId,
			@Param("primarySkill") String[] primarySkill);
}
