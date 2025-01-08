package com.altimetrik.Entity;

import java.util.Date;

public class Employee {
	
	public String employeeID;
	public String employeeName;
	public String capabilityCentre;
	public Date DOJ;
	public String designation;
	public String primarySkill;
	public String secondarySkill;
	public Integer overallExperience;

	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCapabilityCentre() {
		return capabilityCentre;
	}
	public void setCapabilityCentre(String capabilityCentre) {
		this.capabilityCentre = capabilityCentre;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPrimarySkill() {
		return primarySkill;
	}
	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}
	public String getSecondarySkill() {
		return secondarySkill;
	}
	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}
	public Integer getOverallExperience() {
		return overallExperience;
	}
	public void setOverallExperience(Integer overallExperience) {
		this.overallExperience = overallExperience;
	}

}
