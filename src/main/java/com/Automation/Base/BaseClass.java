package com.Automation.Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Automation.Utilities.DriverManager;
import com.Automation.Utilities.Log;
import com.Automation.Utilities.WaitManager;

public class BaseClass {
	
	@BeforeMethod
	public void setup() {
		Properties prop;
		prop = new Properties();
		FileReader reader=null;
		WebDriver driver = null;
		
		try { reader = new FileReader("C:\\Purvesh\\Automation_Workspace\\OrangeHRMTestNG\\src\\main\\resources\\config.properties");
			prop.load(reader);
		} catch (Exception e) {	
			Log.info(e.getMessage());}
		
		switch(prop.getProperty("browser").toLowerCase()) {
		case "chrome":		
			 driver = new ChromeDriver();
			 break;
		case "firefox":		
			 driver = new FirefoxDriver();
			 break;
		case "edge":		
			 driver = new EdgeDriver();
			 break;
		default:
			 Log.info("Invalid browser specified in config.properties file. Please check the file and try again.");
			 break;
		}
		
		DriverManager.setDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(prop.getProperty("url"));
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
