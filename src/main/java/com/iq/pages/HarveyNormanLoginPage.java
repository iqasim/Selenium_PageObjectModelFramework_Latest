package com.iq.pages;

import org.openqa.selenium.By;

import com.iq.enums.WaitStrategy;

public final class HarveyNormanLoginPage extends BasePage {

	private By textboxEmail = By.cssSelector("#email");
	private By textboxPassword = By.cssSelector("#pass");
	private By btnLogin = By.cssSelector("#send2");
	
	public HarveyNormanLoginPage enterEmailId(String email) {
		sendKeys(textboxEmail, email, WaitStrategy.PRESENCE, "Email ID");
		return this;
	}
	
	public HarveyNormanLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE, "Password");
		return this;
	}
	
	public HarveyNormanMyAccountPage clickLoginButton() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new HarveyNormanMyAccountPage();
		
	}
	
	public String getTitle() {
		return getPageTitle();
	}
	
	
}
