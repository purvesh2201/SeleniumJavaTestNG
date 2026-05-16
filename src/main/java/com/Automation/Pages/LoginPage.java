package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Automation.Utilities.DriverManager;
import com.Automation.Utilities.WaitManager;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username") private WebElement usernameField;
	@FindBy(name = "password") private WebElement passwordField;
	@FindBy(css = "button[type='submit']") private WebElement loginButton;
	@FindBy(xpath = "//span[text()='Dashboard']") private WebElement dashboardHeader;
	@FindBy(xpath = "//p[text()='Invalid credentials']") private WebElement invalidCredentialsMessage;
	
	@Test
	public Boolean validLogin(String username,String password) {
		WaitManager.waitForVisibility(usernameField);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		WaitManager.waitForVisibility(dashboardHeader);
		return dashboardHeader.isDisplayed();
	}
	
	public Boolean invalidLogin(String username,String password) {
		WaitManager.waitForVisibility(usernameField);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		WaitManager.waitForVisibility(invalidCredentialsMessage);
		return invalidCredentialsMessage.isDisplayed();
	}
	

}
