package com.altimetrik.utility;

public enum EngineeringRole {

	PRINCIPAL_ENGINEER("Principal Engineer", "PE"), STAFF_ENGINEER("Staff Engineer", "SE"),
	ARCHITECT("Architect", "ARCH"), TECHNICAL_LEAD("Technical Lead", "TL"), SENIOR_ENGINEER("Senior Engineer", "SR"),
	ENGINEER("Engineer", "ENG"), ASSOCIATE_ENGINEER("Associate Engineer", "ASE");

	private final String displayName;
	private final String shortCode;

	EngineeringRole(String displayName, String shortCode) {
		this.displayName = displayName;
		this.shortCode = shortCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getShortCode() {
		return shortCode;
	}

}