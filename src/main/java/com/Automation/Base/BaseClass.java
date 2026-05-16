package com.Automation.Base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Automation.Utilities.DriverManager;
import com.Automation.Utilities.WaitManager;

public class BaseClass {
	
	@BeforeMethod
	public void setup() {
		WebDriver driver = new ChromeDriver();
		DriverManager.setDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WaitManager.setWait(new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)));
	}
	
	@AfterMethod
	public void tearDown() {
		if (DriverManager.getDriver() != null) {
			DriverManager.quitDriver();
			WaitManager.quitWait();
		}
	}

}
