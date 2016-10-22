package dataProvider;

import java.io.IOException;

public class ProgramTest {
	public static void main(String[] args) 
	{
		String propFile = "RunDataProvider\\framework.properties";
		RunConfigurationReader configReader = null;
		try {
			configReader = new RunConfigurationReader(propFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The browser List is "+ configReader.getBrowsers().toString());
		System.out.println("The PageLoadTimeout is "+ configReader.getPageLoadTimeout());
		System.out.println("The ImplicitWait is "+ configReader.getImplicitWaitTimeout());
		
//		String filePath = "TestDataProvider\\TestData.xls";
//		TestDataProviderExcel testData = null;
//		
//		try {
//			testData = new TestDataProviderExcel(filePath);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("The user name for testCase001 is "+ testData.getUserName("Test001"));
//		System.out.println("The user name for testCase002 is "+ testData.getUserName("Test002"));
//		System.out.println("The user name for testCase003 is "+ testData.getUserName("Test003"));
//		
//		System.out.println("The user name for testCase003 is "+ testData.getFirstName("Test003"));
//		
//		testData.closeTestDataSheet();
	}
}
