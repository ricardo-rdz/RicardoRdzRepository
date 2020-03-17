package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverViewPage {

	public WebDriverWait wait;
	public WebDriver driver;
	// ProductsPage Locators
	By getOVPageTitle = By.cssSelector(".subheader");
	By getItemAdded = By.cssSelector(".inventory_item_name");
	By getFinishBtn	= By.cssSelector(".btn_action.cart_button");
	

	
	
	// informationPage Constructor
	public OverViewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	// WebElement Methods
	public WebElement getTitleOVPage() {
		try {
			wait = new WebDriverWait(driver, 10);
			return driver.findElement(getOVPageTitle);
		} catch (Exception e) {
			System.out.println("Locator"+e+ "was not found");
		}
		return null;
	}
	
	public WebElement getItemName() {
		try {
			wait = new WebDriverWait(driver, 10);
			return driver.findElement(getItemAdded);
		} catch (Exception e) {
			System.out.println("Locator"+e+ "was not found");
		}
		return null;
	}
	public WebElement getFshBtn() {
		try {
			wait = new WebDriverWait(driver, 10);
			return driver.findElement(getFinishBtn);
		} catch (Exception e) {
			System.out.println("Locator"+e+ "was not found");
		}
		return null;
	}
}

	
