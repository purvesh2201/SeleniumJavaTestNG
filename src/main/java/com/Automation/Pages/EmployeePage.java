package com.Automation.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Utilities.DriverManager;
import com.Automation.Utilities.WaitManager;

public class EmployeePage {
	
	private WebDriver driver;
	
	public EmployeePage() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='PIM']") private WebElement pimMenu;
	@FindBy(xpath = "//a[text()='Add Employee']") private WebElement addEmployeeLink;
	@FindBy(name = "firstName") private WebElement firstNameField;
	@FindBy(name = "middleName") private WebElement middleNameField;
	@FindBy(name = "lastName") private WebElement lastNameField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
	@FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input") private WebElement employeeIdField;
	@FindBy(xpath = "//h6[text()='TName PLastName']") private WebElement employeeNameHeader;	
	
	public Boolean addEmployee(String fname, String mname, String lname, String empId) {
		WaitManager.waitForVisibility(pimMenu);
		pimMenu.click();
		WaitManager.waitForVisibility(addEmployeeLink);
		addEmployeeLink.click();
		WaitManager.waitForVisibility(firstNameField);
		firstNameField.sendKeys(fname);
		middleNameField.sendKeys(mname);
		lastNameField.sendKeys(lname);
		employeeIdField.clear();
		employeeIdField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		employeeIdField.sendKeys(empId);
		saveButton.click();
		WaitManager.waitForVisibility(employeeNameHeader);
		return employeeNameHeader.isDisplayed();
	}

}

