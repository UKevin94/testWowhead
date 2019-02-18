package test.lardon;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.action.Click;
import test.action.Enter;
import test.action.Go;
import test.action.Scroll;
import test.action.Verify;
import test.action.Wait;

public class LardonTask {

	WebDriver driver;
	WebDriverWait wait;
	String searchValue;
	int itemNb;
	String itemName1;
	String firstStat;
	int firstValue;
	String secondStat;
	int secondValue;
	String itemName2;
	String thirdStat;
	int thirdValue;
	String fourthStat;
	int fourthValue;

	@Before
	public void setUp() {
		String navigateur = System.getProperty("nav");
		if(navigateur.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		//		driver = new FirefoxDriver();
		String width = System.getProperty("winWidth");
		String height = System.getProperty("winHeight");
		Dimension d = new Dimension(Integer.parseInt(width),Integer.parseInt(height));
		driver.manage().window().setSize(d);	
		driver.get("https://fr.wowhead.com/");
		searchValue = "Lardeur";
		itemNb = 5;
		itemName1 = "Chahuteurs de cadavre";
		firstStat = "Intelligence";
		firstValue = 5;
		secondStat = "Endurance";
		secondValue = 8;
		itemName2 = "Chausses de Lardeur";
		thirdStat = "[Agilité or Intelligence]";
		thirdValue = 7;
		fourthStat = "Endurance";
		fourthValue = 10;
		wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	@Test
	public void lardonTask() throws InterruptedException {
		//Thread.sleep(1500);
		Wait.untilVisible(driver, wait, HomePage.searchInput);
		Wait.untilClickable(driver, wait, HomePage.cookieButton);
		Wait.untilVisible(driver, wait, HomePage.cookieButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return window.stop");
		Verify.cookies(driver, HomePage.cookieButton);
		Enter.andInputAfterClear(driver, HomePage.searchInput, "Lardeur");
		Click.on(driver, HomePage.searchButton);
		Wait.untilVisible(driver, wait, SearchPage.pnjButton);
		Scroll.into(driver, SearchPage.pnjButton);
		Click.on(driver, SearchPage.pnjButton);
		Scroll.into(driver, SearchPage.bossLink);
		Click.on(driver, SearchPage.bossLink);
		Wait.untilVisible(driver, wait, NpcPage.npcName);
		Scroll.into(driver, NpcPage.nbListItems);
		Verify.number(driver, NpcPage.nbListItems, itemNb);
		Scroll.into(driver, NpcPage.firstItem);
		Click.on(driver, NpcPage.firstItem);
		Wait.untilVisible(driver, wait, ItemPage.itemName);
		Verify.name(driver, ItemPage.itemName, itemName1);
		Verify.stats(driver, ItemPage.intelStats, firstStat, firstValue);
		Verify.stats(driver, ItemPage.enduStats, secondStat, secondValue);
		Go.back(driver);
		Wait.untilVisible(driver, wait, NpcPage.npcName);
		Scroll.into(driver, NpcPage.secondItem);
		Click.on(driver, NpcPage.secondItem);
		Wait.untilVisible(driver, wait, ItemPage.itemName);
		Verify.name(driver, ItemPage.itemName, itemName2);
		Verify.stats(driver, ItemPage.agintelStats, thirdStat, thirdValue);
		Verify.stats(driver, ItemPage.enduStats, fourthStat, fourthValue);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
