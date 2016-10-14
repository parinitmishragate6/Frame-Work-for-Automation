package unitTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataProvider.RunConfigurationReader;

/*
 * Unit Tests : Tests to validate Run Configuration reader Class 
 * 
 */

public class RunConfigurationTests {
	
	private RunConfigurationReader runConfigReader;
	
	@BeforeClass
	public void setUp() {
		
		try {
			runConfigReader = new RunConfigurationReader("E:\\MyWorkSpace\\WebDriverFrameWork\\RunDataProvider\\framework.properties");
		} catch (IOException e) {
			Assert.assertEquals(false, "Not able to open Configuration file. Stake Trace is " + e.getStackTrace());
		}
	}
	
	@Test(priority = 0)
	public void testSleepTime() {
		
		long sleepTime = runConfigReader.getSleepTime();
		Assert.assertEquals(sleepTime, 2000, "Sleep time retrieved is Incorrect");
		
	}
	
	@Test(priority = 1)
	public void testPageLoadTimeout() {
		
		long pageLoadTimeout = runConfigReader.getPageLoadTimeout();
		Assert.assertEquals(pageLoadTimeout, 5000, "Page load time retrieved is Incorrect");
		
	}
	
	@Test(priority = 2)
	public void testImplicitWaitTimeout() {
		
		long implicitWaitTimeout = runConfigReader.getImplicitWaitTimeout();
		Assert.assertEquals(implicitWaitTimeout, 1000, "Implicit Wait time retrieved is Incorrect");
		
	}
	
	@Test
	public void testIEServerPath() {
		
		String ieServerPath = runConfigReader.getIEServerPath();
		Assert.assertEquals(ieServerPath, "E:\\Trunk\\Drivers\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe", "IE server path is Incorrect");
		
	}
	
}
