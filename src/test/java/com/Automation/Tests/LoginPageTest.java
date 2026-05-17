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
		Log.info(isLoginSuccessful ? "Login successful, dashboard is displayed." : "Login failed, dashboard is not displayed.");
		Log.info("testValidLogin ended.");
	}
	
	@Test
	public void testInvalidLogin() {
		Log.info("testInValidLogin started.");
		LoginPage loginPage = new LoginPage();
		Boolean isErrorMessageDisplayed = loginPage.invalidLogin("wrongAdmin", "wrongPassword");
		Log.info(isErrorMessageDisplayed ? "Invalid credentials message is displayed." : "Invalid credentials message is not displayed.");
		Log.info("testInValidLogin ended.");
	}
	
	

}
