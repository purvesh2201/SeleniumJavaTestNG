package com.Automation.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.Pages.EmployeePage;
import com.Automation.Pages.LoginPage;
import com.Automation.Utilities.DataProviderClass;
import com.Automation.Utilities.Log;

public class EmployeePageTest extends BaseClass {
	
	@Test(dataProvider = "EmployeeData and LoginData" , dataProviderClass = DataProviderClass.class)
	public void testAddEmployee(String username, String password, String fname, String mname, String lname, String empId) {
		Log.info("testAddEmployee started.");
		LoginPage loginPage = new LoginPage();
		loginPage.validLogin(username, password);
		EmployeePage employeePage = new EmployeePage();
		Boolean isemployeeNameHeaderDisplayed = employeePage.addEmployee(fname, mname, lname, empId);	
		Assert.assertTrue(isemployeeNameHeaderDisplayed, "Employee Name Header should be displayed after adding an employee.");
		Log.info(isemployeeNameHeaderDisplayed ? "Employee Name Header is displayed." : "Employee Name Header is not displayed.");
		Log.info("testAddEmployee ended.");
	}

}
