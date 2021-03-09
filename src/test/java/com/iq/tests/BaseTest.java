package com.iq.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.iq.driver.Driver;
import com.iq.driver.DriverManager;
import com.iq.enums.ConfigProperties;
import com.iq.utils.PropertyUtils;

/**
 * @author Imran Qasim
 * 
 * This class contains the setting up and tearing down the environment for all test methods
 *
 */
public class BaseTest {
	/**
	 * Initialized the protected constructor to restrict the visibility to the tests package 
	 */
	protected BaseTest(){
	}
	
	/*
	 * This method initializes the Webdriver
	 */
	@BeforeMethod
	public void setUp(Object[] data) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}
	
	/*
	 * This method quits the Webdriver
	 */
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	
}
