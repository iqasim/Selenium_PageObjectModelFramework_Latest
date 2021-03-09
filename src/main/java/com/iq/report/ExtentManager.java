package com.iq.report;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	/**
	 * Created Thread local object of WebDriver type
	 */
	private static ThreadLocal<ExtentTest> ext = new ThreadLocal<>();
	/**
	 * @return
	 * This method returns the thread safe WebDriver object using get() method of ThreadLocal class
	 */
	static ExtentTest getExtentTest() {
		return ext.get();
	}
	/**
	 * This method set the thread safe WebDriver object using set() method of ThreadLocal class
	 */
	static void setExtentTest(ExtentTest extent) {
		ext.set(extent);
	}
	/**
	 * This method set the removes thread safe object using remove() method of ThreadLocal class
	 */
	static void unload() {
		ext.remove();
	}
	
	
	
	
	
}
