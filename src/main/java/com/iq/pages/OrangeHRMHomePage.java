package com.iq.pages;

import org.openqa.selenium.By;

import com.iq.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.xpath("//a[@id='welcome']");
	private final By linkLogout = By.xpath("//a[contains(@href, 'logout')]");
	
	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.CLICKABLE, "Welcome Link");
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout link");
		return new OrangeHRMLoginPage();
	}
}
