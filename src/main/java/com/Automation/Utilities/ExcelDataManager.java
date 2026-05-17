package com.Automation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataManager {

	@DataProvider(name="LoginTestData" , parallel = true)
	public static String[][] dataProvider(String sheetName) throws IOException {
	
	File excelFile = new File("C:\\Purvesh\\Automation_Workspace\\OrangeHRMTestNG\\src\\main\\resources\\TestData\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(excelFile);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	int totalRows = sheet.getLastRowNum();
	int totalColumns = sheet.getRow(0).getLastCellNum();
	
	String[][] data = new String[totalRows][totalColumns];
	
	for (int i = 0; i < totalRows; i++) {
		for(int j=0;j<totalColumns;j++) {
			DataFormatter df = new DataFormatter();
			String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			data[i][j] = value;
		}
	}
	workbook.close();
	fis.close();
	return data;
}
}

