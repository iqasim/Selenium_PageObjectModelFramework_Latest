package com.iq.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.iq.annotation.FrameworkAnnotation;
import com.iq.enums.CategoryTypes;
import com.iq.pages.AmazonHomePage;

public class AmazonHomePageTest extends BaseTest {
	
	private AmazonHomePageTest() {}
	
	
	@FrameworkAnnotation(author={"Imran", "Qasim"}, category={CategoryTypes.REGRESSION, CategoryTypes.SMOKE})
	@Test
	public void testAmazonHomePage(Map<String, String> data) {
		String title = new AmazonHomePage().clickHamburgerLink().clickMainMenulink(data.get("mainMenuItem")).
				clickSubMenuLink(data.get("subMenuItem")).getTitle();
		System.out.println(title);
		Assertions.assertThat(title).contains("Laptops");
		
	}
	

}
