package com.Automation.Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
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
    
    
    public static boolean waitForSelected(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

	 public static boolean waitForInvisibility(WebElement element) {
		return getWait().until(ExpectedConditions.invisibilityOf(element));
	}
	 
	 public static WebDriver waitForFrame(String frameName) {
		    return getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		}
	 
	 public static Alert waitForAlert() {
		    return getWait().until(ExpectedConditions.alertIsPresent());
		}
	 
	 public static boolean waitForText(WebElement element, String text) {
		    return getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
		}

}
