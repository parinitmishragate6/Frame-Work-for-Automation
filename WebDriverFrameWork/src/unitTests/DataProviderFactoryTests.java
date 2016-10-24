package unitTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.RunConfigurationReader;
import dataProvider.TestDataProviderExcel;
import factories.DataProviderReaderFactory;

public class DataProviderFactoryTests {
	
	@Test
	public void dataProviderInitTest() {
		RunConfigurationReader runreader = DataProviderReaderFactory.getRunConfigDataProvider();
		Assert.assertTrue(runreader != null, "DataProvider factory returned null for a Run Config Provider");
		
		TestDataProviderExcel testdataProvider = DataProviderReaderFactory.getTestDataProvider();
		Assert.assertTrue(testdataProvider != null, "DataProvider factory returned null for a Test Data Provider");
	}
	
	@Test
	public void dataProviderInstanceTest() {
		RunConfigurationReader runreader1 = DataProviderReaderFactory.getRunConfigDataProvider();
		RunConfigurationReader runreader2 = DataProviderReaderFactory.getRunConfigDataProvider();
		Assert.assertTrue(runreader1.equals(runreader2), "DataProvider factory returned difrent instances of Run Config Provider");
		
		TestDataProviderExcel testdataProvider1 = DataProviderReaderFactory.getTestDataProvider();
		TestDataProviderExcel testdataProvider2 = DataProviderReaderFactory.getTestDataProvider();
		Assert.assertTrue(testdataProvider1.equals(testdataProvider2), "DataProvider factory returned difrent instances of Test Data Provider");
	}
}
