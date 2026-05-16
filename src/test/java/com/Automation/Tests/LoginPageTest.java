package com.Automation.Tests;

import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.Pages.LoginPage;
import com.Automation.Utilities.Log;

public class LoginPageTest extends BaseClass {
	
	@Test
	public void testValidLogin() {
		Log.info("testValidLogin started.");
		LoginPage loginPage = new LoginPage();
		Boolean isLoginSuccessful = loginPage.validLogin("Admin", "admin123");
		if (isLoginSuccessful) {
			Log.info("Valid login test passed.");
		} else {
			Log.error("Valid login test failed.");
		}	
		Log.info("testValidLogin ended.");
	}
	
	@Test
	public void testInvalidLogin() {
		Log.info("testInValidLogin started.");
		LoginPage loginPage = new LoginPage();
		Boolean isErrorMessageDisplayed = loginPage.invalidLogin("wrongAdmin", "wrongPassword");
		if (isErrorMessageDisplayed) {
			Log.info("Invalid login test passed....");
		} else {
			Log.error("Invalid login test failed....");
		}
		Log.info("testInValidLogin ended.");
	}
	
	

}
