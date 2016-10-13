package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Purpose : The purpose of this Class to provide TestData from an Excel file 
 * 
 * Apache POI is the library to read Excel files
 * 
 */


public class TestDataProviderExcel {

	private String testDataFilePath;
	private FileInputStream fileStream;
	
	private Workbook testDataWorkbook;
	private Sheet testDataSheet;
	
	/*private HSSFWorkbook testDataWorkBookOld;
	private HSSFSheet testDataSheetOld;*/
	
	public TestDataProviderExcel(String testDataFilePath) throws IOException {
		
		this.testDataFilePath = testDataFilePath;
		fileStream = new FileInputStream(new File(this.testDataFilePath));
		
		// Reading both Excel 2003 and 2007
		if (testDataFilePath.endsWith("xlsx")) {
			
			testDataWorkbook = new XSSFWorkbook(fileStream);
			testDataSheet = testDataWorkbook.getSheetAt(0);
			
	    } else if (testDataFilePath.endsWith("xls")) {
	    	
	    	testDataWorkbook = new HSSFWorkbook(fileStream);
	    	testDataSheet = testDataWorkbook.getSheetAt(0);
	    
	    } else {
	        
	    	throw new IllegalArgumentException("The specified file is not Excel file");
	    
	    }
		
	}
	
	private String getData(String testCaseName, String keyName) {
		
		String value = "";
		if (testDataFilePath.endsWith("xlsx")) {
			
			int rowEnd = testDataSheet.getLastRowNum();
			for (int i = 1; i < rowEnd; i++) {

				String testName = testDataSheet.getRow(i).getCell(0).getStringCellValue();
				if (testName.equalsIgnoreCase(testCaseName)) {

					int j = 0;
					
					String colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
					
					while (!colName.isEmpty()) {
						
						colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
						
						if (colName.equals(keyName)) {

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
		} else {
			
			int rowEnd = testDataSheet.getLastRowNum();
			for (int i = 1; i < rowEnd; i++) {

				String testName = testDataSheet.getRow(i).getCell(0).getStringCellValue();
				
				if (testName.equalsIgnoreCase(testCaseName)) {

					int j = 0;
					
					String colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
					
					while (!colName.isEmpty()) {
						
						colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
						if (colName.equals(keyName)) {

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
			
		}
		
		return value;
		
	}
	
	
	public String getUserName(String testCaseName) {
		
		String userName = getData(testCaseName, "UserName");
		return userName;
	}
	
	public String getPassword(String testCaseName) {
		
		String password = getData(testCaseName, "Password");
		return password;
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
