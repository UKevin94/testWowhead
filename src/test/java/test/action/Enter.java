package test.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enter {

	public static void andInputAfterClear(WebDriver driver, By locator, String value) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}
}
