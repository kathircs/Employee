package com.altimetrik.utility;

public enum CapabilityCentre {

	DEP_CLOUD("DEP-Cloud", "DEPCLOUD"), DEP_QUALITY("DEP-Quality", "DEPQUALITY"), DEVAA("DEVAA", "DEVAA");

	private final String displayName;
	private final String shortCode;

	CapabilityCentre(String displayName, String shortCode) {
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