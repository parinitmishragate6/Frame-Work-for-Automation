package dataProvider;

import java.io.IOException;

public class TestProgram {

	public static void main(String[] args) throws IOException {
	
	// Property File	
		String propFile = "E:\\MyWorkSpace\\WebDriverFrameWork\\RunDataProvider\\framework.properties";
		RunConfigurationReader configReader = null;
		try {
			configReader = new RunConfigurationReader(propFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The browser List is "+ configReader.getBrowsers().toString());
		System.out.println("The PageLoadTimeout is "+ configReader.getPageLoadTimeout());
		System.out.println("The Firefox Server Path is "+ configReader.getFirefoxServerPath());
		System.out.println("It will take ScreenShot On Failure : "+ configReader.getScreenShotOnFailure());		
	
	// For Excel Sheet	
		String filePath = "E:\\MyWorkSpace\\WebDriverFrameWork\\TestDataProvider\\TestData.xls";
		
		TestDataProviderExcel testData = null;
		
		
			testData = new TestDataProviderExcel(filePath);
		
		
		System.out.println("The User name for testCase001 is "+ testData.getUserName("Test001"));
		System.out.println("The Password for testCase002 is "+ testData.getPassword("Test002"));
		System.out.println("The First name for testCase003 is "+ testData.getFirstName("Test003"));
		
		System.out.println("The Last name for testCase001 is "+ testData.getLastName("Test001"));
		System.out.println("The Email for testCase002 is "+ testData.getEmail("Test002"));
		System.out.println("The Product name for testCase003 is "+ testData.getProductName("Test003"));
		
		System.out.println("The Product ID for testCase001 is "+ testData.getProductID("Test001"));
		System.out.println("The Price for testCase002 is "+ testData.getPrice("Test002"));
		
		testData.closeTestDataSheet();
	
	}
	
}
