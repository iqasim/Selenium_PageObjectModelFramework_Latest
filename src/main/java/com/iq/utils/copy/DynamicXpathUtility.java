package com.iq.utils.copy;

public final class DynamicXpathUtility {
	
	private DynamicXpathUtility() {}
	
	public static String getXpath(String xpath, String value) {
			return	xpath.replace("%replaceable%", value); 
	}
	
	

}
