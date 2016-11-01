package testRunner;

import java.util.List;

import org.testng.TestNG;

import factories.BrowserFactory;
import factories.DataProviderFactory;
import factories.ReporterFactory;

public class RunManager {
	
	public static void main(String[] args) {
		
		List<String> browserList = DataProviderFactory.getRunConfigDataProvider().getBrowsers();
		List<String> suites = DataProviderFactory.getRunConfigDataProvider().getRunXmls();		// Add testXML suites(i)
		TestNG testRunner = null;		
		
		for (String browser : browserList) {
			
			ReporterFactory.getReporter().Log("Starting tests with browser " + browser);
			
			BrowserFactory.getBrowser(browser);
			testRunner = new TestNG();
			
			testRunner.setTestSuites(suites);			// Add testXML suites(ii)
			testRunner.run();
			
			BrowserFactory.colseWebDriver();
			
			ReporterFactory.getReporter().Log("Stopping tests with browser " + browser);
		}
		ReporterFactory.getReporter().StopLogging();
	}
}
