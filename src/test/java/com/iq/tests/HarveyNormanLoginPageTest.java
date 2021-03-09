package com.iq.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.testng.annotations.Test;

import com.iq.pages.HarveyNormanLoginPage;

public final class HarveyNormanLoginPageTest extends BaseTest {

	private HarveyNormanLoginPageTest() {
		
	}
	
	@Test
	public void testLoginLogout(Map<String, String> data) {
		String title = new HarveyNormanLoginPage()
				.enterEmailId(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
				.clickLogoutButton()
				.getTitle();
		assertThat(title)
		.isEqualTo("Harvey Norman | Shop Online for Computers, Electrical, Furniture, Bedding, Bathrooms &amp; Flooring | Harvey Norman Australia");
	}
		
}
