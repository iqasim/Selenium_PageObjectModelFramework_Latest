package com.iq.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.iq.enums.ConfigProperties;
import com.iq.exceptions.BrowserInvocationException;
import com.iq.factories.DriverFactory;
import com.iq.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Imran Qasim
 * 
 * This class contains the WebDriver initialization and loading the browser drivers and browsers
 *
 */
public final class Driver {
	/**
	 * Restricted class to be instantiated via creating private constructor
	 */
	private Driver() {
	}

	/**
	 * This initDriver() method initializes the driver and before initializing first it validates that driver should be null 
	 * @throws Exception 
	 */
	public static void initDriver(String browser) {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getWebDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationException("Please check the capabilities of the browser.");
			}
		}
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
	}


	/**
	 * This quitDriver() method quits the driver and before quitting first it validates that driver should not be null
	 */
	public static void quitDriver() {
		if(java.util.Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}