package com.iq.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iq.constants.FrameworkConstants;
import com.iq.driver.DriverManager;
import com.iq.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	protected ExplicitWaitFactory(){
	}

	public static WebElement setExplicitWait(By by, WaitStrategy waitStrategy) {
		WebElement element = null;
		if(waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).
					until(ExpectedConditions.elementToBeClickable(by));
		} else if(waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).
					until(ExpectedConditions.presenceOfElementLocated(by));
		} else if(waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait()).
					until(ExpectedConditions.visibilityOfElementLocated(by));
		}else if(waitStrategy==WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;

	}


}
