package com.iq.pages;

import org.openqa.selenium.By;

import com.iq.driver.DriverManager;
import com.iq.enums.WaitStrategy;
import com.iq.utils.DecodeUtils;

/**
 * @author Imran Qasim
 * 
 * This Page class contains the page elements of Orange HRM Login page and their associated methods
 *
 */

public final class OrangeHRMLoginPage extends BasePage {
	
	/**
	 * Page Elements of Login Page
	 * Username Textbox
	 * Password TextBox
	 * Submit Button
	 * 
	 */
	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By btnLogin = By.id("btnLogin");
	
	/**
	 * @param username
	 * @return
	 * Enter username method
	 * 
	 */
	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, "Username textbox");
		return this;
	}
	
	/**
	 * @param password
	 * @return
	 *  Enter Password method
	 */
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password textbox");
		return this;
	}
	
	/**
	 * @return
	 * Click on Submit button
	 */
	public OrangeHRMHomePage clickLoginButton() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login Button");
		return new OrangeHRMHomePage();
	}
	
	/**
	 * @return
	 * Get Title method
	 */
	public String getTitle() {
		return getPageTitle();
	}
}
