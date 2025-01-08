package com.altimetrik.utility;

public enum AccountName {

	ANCESTRY("Ancestry", "ANCS"),
	BNYM("Bank of New York Mellon", "BNYM"),
	CALIBO("Calibo LLC", "CLBO"),
	EXPERIAN("Experian", "EXPR"),
	FORD("Ford Motor Company", "FORD"),
	GUARANTEED_RATE("Guaranteed Rate", "GUAR"),
	INVOICE_CLOUD("Invoice Cloud", "INVC"),
	VATTIKUTI_VENTURES("Vattikuti Ventures LLC", "VATV"),
	ZIP_CO("Zip Co US Inc", "ZIPC"),
	PAYPAL("PayPal", "PYPL"),
	JOHNSON_CONTROLS("Johnson Controls Inc", "JCI"),
	WESTERN_UNION("Western Union", "WU");

	private final String displayName;
	private final String shortCode;

	AccountName(String displayName, String shortCode) {
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