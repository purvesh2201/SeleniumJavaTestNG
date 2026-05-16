package com.Automation.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {
	
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
	
	public static WebDriverWait getWait() {
		return wait.get();
	}
	
	public static void setWait(WebDriverWait waitInstance) {
		wait.set(waitInstance);
	}
	
	public static void quitWait() {
		if (wait.get() != null) {
			wait.remove();
		}
	}
	
    public static WebElement waitForVisibility(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

}
