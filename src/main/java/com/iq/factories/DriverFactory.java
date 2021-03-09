package com.iq.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.iq.enums.ConfigProperties;
import com.iq.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {}

	public static WebDriver getWebDriver(String browser) throws MalformedURLException {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			if(PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("chrome");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			}	
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			if(PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			}else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
