package com.iq.pages;

import org.openqa.selenium.By;

import com.iq.enums.WaitStrategy;
import com.iq.utils.DynamicXpathUtility;

public final class AmazonHomePage extends BasePage {
	
		
	private By menuHamburger = By.id("nav-hamburger-menu");
	
	String mainMenuLinks = "//div[text()='%replaceable%']/parent::a"; 
	
	String subMenuLinks = "//a[text()='%replaceable%']";
	
	
	public AmazonHomePage clickHamburgerLink() {
		click(menuHamburger, WaitStrategy.CLICKABLE, "Hamburger Menu");
		return this;
	}
	
	public AmazonHomePage clickMainMenulink(String mainMenuItem) {
		click(By.xpath(DynamicXpathUtility.getXpath(mainMenuLinks, mainMenuItem)), WaitStrategy.CLICKABLE, "Computers Menu");
		return this;
	}
	
	public AmazonHomePage clickSubMenuLink(String subMenuItem) {
		click(By.xpath(DynamicXpathUtility.getXpath(subMenuLinks, subMenuItem)), WaitStrategy.CLICKABLE, "Laptops");
		return this;
	}
	
	public String getTitle() {
		return getPageTitle();
	}

}
