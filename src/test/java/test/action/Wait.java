package test.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void untilVisible(WebDriver driver, WebDriverWait wait, By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void untilClickable(WebDriver driver, WebDriverWait wait, By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
