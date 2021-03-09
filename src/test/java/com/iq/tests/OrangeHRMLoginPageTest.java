package com.iq.tests;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import org.testng.annotations.Test;

import com.iq.annotation.FrameworkAnnotation;
import com.iq.enums.CategoryTypes;
import com.iq.pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginPageTest extends BaseTest {

	private OrangeHRMLoginPageTest() {
		
	}
	
	@FrameworkAnnotation(author = {"Imran"}, category = CategoryTypes.SMOKE)
	@Test
	public void testLoginLogout(Map<String, String> data) {
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
				.clickWelcome().clickLogout()
				.getTitle();
		assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	@FrameworkAnnotation(author = {"Imran"}, category = CategoryTypes.REGRESSION)
	@Test
	public void newTest(Map<String, String> data) {
		String title = new OrangeHRMLoginPage()
				.enterUsername(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
				.clickWelcome().clickLogout()
				.getTitle();
		assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
}
