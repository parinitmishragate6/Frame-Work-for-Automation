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
	
	@Test(priority = 0)
	public void testUsernaame() {
		
		String userName = testDataReader.getUserName("Test001");
		Assert.assertEquals(userName, "username1", "Incorrect value of User name retrieved");
		
	}
	
	@Test(priority = 1)
	public void testPassword() {
		String password = testDataReader.getPassword("Test002");
		Assert.assertEquals(password, "password2", "Incorrect value of Password retrieved");
	}
	
	@Test(priority = 2)
	public void testFirstName() {
		String firstName = testDataReader.getFirstName("Test003");
		Assert.assertEquals(firstName, "Tester_03", "Incorrect value of First Name retrieved");
	}
	
	@Test(priority = 3)
	public void testLastName() {
		String lastName = testDataReader.getLastName("Test004");
		Assert.assertEquals(lastName, "Case_04", "Incorrect value of Last Name retrieved");
	}
	
	@Test(priority = 4)
	public void testEmail() {
		
		String email = testDataReader.getEmail("Test001");
		Assert.assertEquals(email, "parinit1@abc.com", "Incorrect value of email retrieved");
	}
	
	@Test(priority = 5)
	public void testProductName() {
		
		String productName = testDataReader.getProductName("Test002");
		Assert.assertEquals(productName, "Laptop Dell", "Incorrect value of Product Name retrieved");
	}
	
	@Test(priority = 6)
	public void testProductID() {
		
		String productID = testDataReader.getProductID("Test003");
		Assert.assertEquals(productID, "1236", "Incorrect value of Product ID retrieved");
	}
	
	@Test(priority = 7)
	public void testPrice() {
		
		String price = testDataReader.getPrice("Test004");
		Assert.assertEquals(price, "47", "Incorrect value of Price retrieved");
	}
}
