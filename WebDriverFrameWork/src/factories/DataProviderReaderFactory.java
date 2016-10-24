package factories;

import java.io.IOException;

import dataProvider.RunConfigurationReader;
import dataProvider.TestDataProviderExcel;

/*
 * The purpose of this Class is to
 * -> Create Run Configuration Reader
 * -> Maintain an instance of the Reader so that single reader can be used across Tests or Framework
 * 
 */

public class DataProviderReaderFactory {
	private static RunConfigurationReader runDataProvider = null;
	private static TestDataProviderExcel testdataProvider = null;
	private static String runConfigFilePath = "framework.properties";
	private static String testDataFilePath = "TestData.xls";
	
	public static RunConfigurationReader getRunConfigDataProvider() {
		if (runDataProvider == null) {
			try {
				runDataProvider = new RunConfigurationReader(runConfigFilePath);
			} catch (IOException e) {
				System.out.println("Not able to create config reader. Exception -> " + e.getMessage());
			}
		}
		return runDataProvider;
	}
	
	public static TestDataProviderExcel getTestDataProvider() {
		if (testdataProvider == null) {
			try {
				testdataProvider = new TestDataProviderExcel(testDataFilePath);
			} catch (IOException e) {
				System.out.println("Not able to create Test data provider. Exception -> " + e.getMessage());
			}
		}
		return testdataProvider;
	}
}
