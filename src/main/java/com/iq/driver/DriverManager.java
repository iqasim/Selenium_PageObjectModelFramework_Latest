package com.iq.driver;

import org.openqa.selenium.WebDriver;

/**
 * @author Imran Qasim
 * 
 * This Class manages the driver and enables WebDriver to run in a thread safe environment
 *
 */
public final class DriverManager {
	/**
	 * Created Thread local object of WebDriver type
	 */
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	/**
	 * @return
	 * This method returns the thread safe WebDriver object using get() method of ThreadLocal class
	 */
	public static WebDriver getDriver() {
		return dr.get();
	}
	/**
	 * This method set the thread safe WebDriver object using set() method of ThreadLocal class
	 */
	public static void setDriver(WebDriver driverRef) {
		dr.set(driverRef);
	}
	/**
	 * This method set the removes thread safe object using remove() method of ThreadLocal class
	 */
	public static void unload() {
		dr.remove();
	}
	private DriverManager() {
	}
}