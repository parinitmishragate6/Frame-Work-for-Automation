package unitTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factories.BrowserFactory;

public class BrowserFactoryTests {
	
	// Browser Factory instantiation Test 
	@Test
	public void browserFactoryInitTest() {
		WebDriver driver = BrowserFactory.getBrowser("Firefox");
		Assert.assertTrue(driver != null, "BrowserFactory returned a null WebDriver");
	}
	
	@Test
	public void browserFactoryWebDriverInstancetest() {
		WebDriver driver1 = BrowserFactory.getBrowser("InternetExplorer");
		WebDriver driver2 = BrowserFactory.getBrowser("InternetExplorer");
		
		Assert.assertTrue(driver1.equals(driver2), "The two WebDriver returned are not the same.");
	}
}
