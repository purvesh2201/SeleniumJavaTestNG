package com.Automation.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.Pages.LoginPage;
import com.Automation.Utilities.ExcelDataManager;
import com.Automation.Utilities.Log;


public class LoginPageTest extends BaseClass {
	
	
    @DataProvider(name = "LoginTestData")
    public Object[][] validlogindata() throws IOException {
        return ExcelDataManager.dataProvider("ValidLogin");
    }

    @DataProvider(name = "InValidLoginTestData")
    public Object[][] invalidlogindata() throws IOException {
        return ExcelDataManager.dataProvider("InValidLogin");
    }
	

	@Test(dataProvider = "LoginTestData")
	public void testValidLogin(String username, String password) {
		Log.info("testValidLogin started.");
		LoginPage loginPage = new LoginPage();
		Boolean isLoginSuccessful = loginPage.validLogin(username, password);
		Assert.assertTrue(isLoginSuccessful, "Login should be successful with valid credentials.");
		Log.info(isLoginSuccessful ? "Login successful, dashboard is displayed." : "Login failed, dashboard is not displayed.");
		Log.info("testValidLogin ended.");
	}
	

	@Test(dataProvider = "InValidLoginTestData")
	public void testInvalidLogin(String username, String password) {
		Log.info("testInValidLogin started.");
		LoginPage loginPage = new LoginPage();
		Boolean isErrorMessageDisplayed = loginPage.invalidLogin(username, password);
		Assert.assertTrue(isErrorMessageDisplayed, "Invalid credentials message should be displayed for invalid login.");
		Log.info(isErrorMessageDisplayed ? "Invalid credentials message is displayed." : "Invalid credentials message is not displayed.");
		Log.info("testInValidLogin ended.");
	}
	
	

}
