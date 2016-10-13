package unitTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataProvider.TestDataProviderExcel;

/*
 * Unit Tests : Tests to validate Testdata Provider Excel Class
 * 
 */

public class TestDataProviderTests {

	private TestDataProviderExcel testDataReader;
	
	@BeforeClass
	public void setUp() {
		
		try {
			testDataReader = new TestDataProviderExcel("E:\\MyWorkSpace\\WebDriverFrameWork\\TestDataProvider\\TestData.xls");
		} catch (IOException e) {
			Assert.assertEquals(false, "Not able to Open test data file. Stake trace is " + e.getStackTrace());
		}
	}
	
	@Test
	public void testUsernaame() {
		
		String userName = testDataReader.getUserName("Test001");
		Assert.assertEquals(userName, "username1", "Incorrect value of User name retrieved");
		
	}
	
	@Test
	public void testProductID() {
		
		String productID = testDataReader.getProductID("Test002");
		Assert.assertEquals(productID, "1235", "Incorrect value of Product ID retrieved");
	}
	
	@Test
	public void testEmail() {
		
		String email = testDataReader.getEmail("Test004");
		Assert.assertEquals(email, "parinit14@abc.com", "Incorrect value of email retrieved");
	}
}
