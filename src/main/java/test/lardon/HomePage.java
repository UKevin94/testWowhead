package test.lardon;

import org.openqa.selenium.By;

public class HomePage {

	public static By searchInput = By.xpath("//input[@name='q'][@type='text']");
	public static By searchButton = By.xpath("//a[@class='header-search-button fa fa-search']");
	public static By cookieButton = By.xpath("//button[contains(@class,'banner_save')][text()='Continue Using Site']");
	
}
