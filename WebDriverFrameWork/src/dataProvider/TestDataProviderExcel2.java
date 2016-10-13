package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

/*
 * Purpose : The purpose of this Class to provide TestData from an Excel file 
 * 
 * Apache POI is the library to read Excel files
 */

public class TestDataProviderExcel2 {
	
	private String testDataFilePath;
	private FileInputStream fileStream;
	
/*	// For .xlsx Format 
	private XSSFWorkbook testDataWorkbook;
	private XSSFSheet testDataSheet;

*/
	// For .xls Format
	private HSSFWorkbook testDataWorkbook;
	private HSSFSheet testDataSheet;
	
	
	public TestDataProviderExcel2(String testDataFilePath) throws IOException
	{
		this.testDataFilePath = testDataFilePath;
		fileStream = new FileInputStream(new File(this.testDataFilePath));
		testDataWorkbook = new HSSFWorkbook(fileStream);
		testDataSheet = testDataWorkbook.getSheet("TestData");
	}
	
	private String getData(String testCaseName, String keyName)
	{
		int rowEnd = testDataSheet.getLastRowNum();
		String value = "";
		
		for(int i = 1; i <= rowEnd; i++)
		{
			String testName = testDataSheet.getRow(i).getCell(0).getStringCellValue();
			
			if(testName.equals(testCaseName))
			{
				int j = 0;
				String colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
				
				while(!colName.isEmpty())
				{
					colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
					if(colName.equals(keyName))
					{
						if(testDataSheet.getRow(i).getCell(j).getCellType()==XSSFCell.CELL_TYPE_NUMERIC){
							value = String.valueOf(new Double(testDataSheet.getRow(i).getCell(j).getNumericCellValue()).intValue());
						} else {
							value = testDataSheet.getRow(i).getCell(j).getStringCellValue();
						}
						
						break;
					}
					j++;
				}
				break;
			}
		}
		return value;
	}
	
	public String getUserName(String testCaseName)
	{
		return getData(testCaseName, "UserName");
	}
	
	public String getPassword(String testCaseName)
	{
		return getData(testCaseName, "Password");
	}
	
	public String getFirstName(String testCaseName)
	{
		return getData(testCaseName, "FirstName");
	}
	
	public String getLastName(String testCaseName)
	{
		return getData(testCaseName, "LastName");
	}
	
	public String getEmail(String testCaseName)
	{
		return getData(testCaseName, "Email");
	}
	
	public String getProductName(String testCaseName)
	{
		return getData(testCaseName, "ProductName");
	}
	
	public String getProductID(String testCaseName)
	{
		return getData(testCaseName, "ProductID");
	}
	
	public String getPrice(String testCaseName)
	{
		return getData(testCaseName, "Price");
	}
	
	public String getTestData(String testCaseName, String keyName)
	{
		return getData(testCaseName, keyName);
	}
	
	public void closeTestDataSheet()
	{
		try {
			testDataWorkbook.close();
			fileStream.close();
		} catch (IOException e) {
			
			// Log this Information
			
		}
		
	}
}
