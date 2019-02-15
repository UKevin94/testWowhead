package test.lardon;

import org.openqa.selenium.By;

public class NpcPage {

	public static By npcName = By.xpath("//h1[@class='heading-size-1']");
	public static By nbListItems = By.xpath("//tr[ancestor::div[@id='tab-drops']][ancestor::div[@class='listview-scroller']][parent::tbody[@class='clickable']][descendant::a[contains(@class,'q3')]]");
	public static By firstItem = By.xpath("//tr[ancestor::div[@id='tab-drops']][ancestor::div[@class='listview-scroller']]/descendant::a[contains(@href,'item')][1]");
	public static By secondItem = By.xpath("//tr[ancestor::div[@id='tab-drops']][ancestor::div[@class='listview-scroller']][2]/descendant::a[contains(@href,'item')][1]");
}
