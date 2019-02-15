package test.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

public class Verify {

	public static void number(WebDriver driver, By locator, int expected) {
		Assert.assertEquals(expected, driver.findElements(locator).size());
	}
	
	public static void name(WebDriver driver, By locator, String expected) {
		Assert.assertEquals(expected, driver.findElement(locator).getText());
	}
	
	public static void stats(WebDriver driver, By locator, String statName,int expectedValue) {
		String value = driver.findElement(locator).getText();
		value = value.substring(1, value.indexOf(statName));
		value = value.trim();
		Assert.assertEquals(expectedValue, Integer.parseInt(value));
	}
	
	public static void cookies(WebDriver driver, By locator) {
		if(driver.findElements(locator).size()>0)
		{
			driver.findElement(locator).click();
		}
	}
}
