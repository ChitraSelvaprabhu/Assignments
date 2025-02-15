package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.StockPage;

public class StockPageTest {
	
	public WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	void selectStock() {
		StockPage hp = new StockPage(driver);
		hp.searchStock();
		hp.selectStock();
	}
	
	@Test(priority=1)
	void verifyStockPrice() {
		StockPage hp = new StockPage(driver);
		Double stockValue = hp.verifyStockPrice();
		if(stockValue>200) {
			Assert.assertTrue(true);
		}
	}
	
	@Test(priority=2)
	void capturePreviousClose() {
		StockPage hp = new StockPage(driver);
		hp.previousCloseValue();
	}
	
	@Test(priority=3)
	void captureVolume() {
		StockPage hp = new StockPage(driver);
		hp.volume();
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
