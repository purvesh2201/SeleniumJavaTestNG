package com.Automation.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
    @DataProvider(name = "LoginTestData")
    public Object[][] validlogindata() throws IOException {
        return ExcelDataManager.dataProvider("ValidLogin");
    }

    @DataProvider(name = "InValidLoginTestData")
    public Object[][] invalidlogindata() throws IOException {
        return ExcelDataManager.dataProvider("InValidLogin");
    }
    
    
    @DataProvider(name = "EmployeeData and LoginData")
    public Object[][] loginAndEmployeeData() throws IOException {
        return ExcelDataManager.dataProvider("LoginAndEmployeeData");
    }

}
