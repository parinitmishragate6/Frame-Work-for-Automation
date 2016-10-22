package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * Purpose : This Class help us to Read framework.properties file 
 * 			 And it will help us to get the Data from the mentioned file
 * 
 */

public class RunConfigurationReader {
	
	Properties propertyFile;
	String fileName;
	
	public RunConfigurationReader(String propertyFilePath) throws IOException {
		
		this.fileName = propertyFilePath;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		propertyFile = new Properties();
		propertyFile.load(reader);
		reader.close();
	
	}
	
	// To get Browsers
	public List<String> getBrowsers() {
		
		String browserName = propertyFile.getProperty("browserType");
		String[] browserArray = browserName.split(",");
		List<String> browserList = new ArrayList<String>();
		
		for(int i=0; i<browserArray.length; i++) {
			
			browserList.add(browserArray[i]);
			
		}
		
		return browserList;
		
	}
	
	// Wait Time
	
	public long getImplicitWaitTimeout() {
		
		String implicitWaitTimeout = propertyFile.getProperty("implicitWait");
		return Long.parseLong(implicitWaitTimeout);
		
	}
	
	public long getPageLoadTimeout() {
		
		String pageLoadTimeout = propertyFile.getProperty("pageLoadTimeout");
		return Long.parseLong(pageLoadTimeout);
		
	}
	
	public long getSleepTime() {
		
		String sleepTime = propertyFile.getProperty("sleepTime");
		return Long.parseLong(sleepTime);
		
	}
	
	/** Utilities */
	// Screen Shot On Failure
	public boolean getScreenShotOnFailure() {
		
		String screenShotOnFailure = propertyFile.getProperty("screenShotOnFailure");
		return Boolean.parseBoolean(screenShotOnFailure);
		
	}
	
	// Highlight Elements
	public boolean getHighlightElements() {
		
		String highlightElement = propertyFile.getProperty("highlightElement");
		return Boolean.parseBoolean(highlightElement);
		
	}
	
	/** Drivers */
	// Firefox Driver
	public String getFirefoxServerPath() {
		
		String firefoxServerPath = propertyFile.getProperty("FirefoxServerPath");
		return firefoxServerPath;
		
	}
	
	// IE Server Path
	public String getIEServerPath() {
		
		String iEServerPath = propertyFile.getProperty("IEServerPath");
		return iEServerPath;
		
	}
	
	// Chrome Server Path
	public String getChromeServerPath() {
		
		String chromeServerPath = propertyFile.getProperty("ChromeServerPath");
		return chromeServerPath;
		
	}
	
}