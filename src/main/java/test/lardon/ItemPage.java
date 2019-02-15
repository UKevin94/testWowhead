package test.lardon;

import org.openqa.selenium.By;

public class ItemPage {

	public static By itemName = By.xpath("//h1[@class='heading-size-1']");
	public static By intelStats = By.xpath("//span[contains(text(), 'Intelligence')]");
	public static By enduStats = By.xpath("//span[contains(text(), 'Endurance')]");
	public static By agintelStats = By.xpath("//span[contains(text(), '[Agilité or Intelligence]')]");

}
