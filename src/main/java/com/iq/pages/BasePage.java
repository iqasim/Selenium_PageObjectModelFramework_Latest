package com.iq.pages;

import org.openqa.selenium.By;

import com.iq.driver.DriverManager;
import com.iq.enums.WaitStrategy;
import com.iq.factories.ExplicitWaitFactory;
import com.iq.report.ExtentLogger;

public class BasePage {

	protected BasePage(){
	}

	protected void click(By by, WaitStrategy waitStrategy, String element) {
		ExplicitWaitFactory.setExplicitWait(by, waitStrategy).click();
		ExtentLogger.pass(String.valueOf(element +" is clicked"));
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String element) {
		ExplicitWaitFactory.setExplicitWait(by, waitStrategy).sendKeys(value);
		ExtentLogger.pass(String.valueOf(value+ " is entered in the " +element));
	}
	

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}





}
