package com.Automation.Tests;

import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.Pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	@Test
	public void testValidLogin() {
		
		LoginPage loginPage = new LoginPage();
		Boolean isLoginSuccessful = loginPage.validLogin("Admin", "admin123");
		if (isLoginSuccessful) {
			System.out.println("Valid login test passed.");
		} else {
			System.out.println("Valid login test failed.");
		}	
	}
	
	@Test
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage();
		Boolean isErrorMessageDisplayed = loginPage.invalidLogin("wrongAdmin", "wrongPassword");
		if (isErrorMessageDisplayed) {
			System.out.println("Invalid login test passed....");
		} else {
			System.out.println("Invalid login test failed....");
		}
	}
	
	

}
