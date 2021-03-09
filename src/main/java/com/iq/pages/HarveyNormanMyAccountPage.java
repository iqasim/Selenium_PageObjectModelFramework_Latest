package com.iq.pages;

import org.openqa.selenium.By;

import com.iq.enums.WaitStrategy;

public final class HarveyNormanMyAccountPage extends BasePage {
	
	protected HarveyNormanMyAccountPage() {}
	private By btnLogout = By.cssSelector(".btn.btn_block");
	
	public HarveyNormanLoginPage clickLogoutButton() {
		click(btnLogout, WaitStrategy.CLICKABLE, "Logout Button");
		return new HarveyNormanLoginPage();
	}
	
	
	

}
