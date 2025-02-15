package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class StockPage extends BasePage {
	
	public StockPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@id='ybar-sbq']")
private WebElement searchSymbol;

@FindBy(xpath="//ul[@class='modules-module_list__hi5kT']/li[1]//div[text()='Tesla, Inc.']")
private WebElement firstStock;

@FindBy(css="span[data-testid='qsp-price']")
private WebElement stockPrice;

@FindBy(css=".yf-gn3zu3[data-symbol='TSLA'][data-field='regularMarketPreviousClose']")
private WebElement previousClose;

@FindBy(css=".yf-gn3zu3[data-symbol='TSLA'][data-field='regularMarketVolume']")
private WebElement volume;

	public void searchStock() {
		searchSymbol.sendKeys("TSLA");
	}
	
	public void selectStock() {
		System.out.println(firstStock.getText());
		firstStock.click();
	}
	
	public Double verifyStockPrice() {
		Double stockValue = Double.valueOf(stockPrice.getText());
		return stockValue;
	}
	
	public void previousCloseValue() {
		System.out.println(previousClose.getText());
	}
	
	public void volume() {
		System.out.println(volume.getText());
	}

}
