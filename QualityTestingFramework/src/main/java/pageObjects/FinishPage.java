package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinishPage {

	public WebDriverWait wait;
	public WebDriver driver;
	// ProductsPage Locators
	By getFinishMs = By.cssSelector(".complete-header");
	By getFPageTitle = By.cssSelector(".subheader");
	
	

	
	
	// informationPage Constructor
	public FinishPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	// WebElement Methods
	public WebElement getFinishMessage() {
		try {
			wait = new WebDriverWait(driver, 10);
			return driver.findElement(getFinishMs);
		} catch (Exception e) {
			System.out.println("Locator"+e+ "was not found");
		}
		return null;
	}
	public WebElement getFinishPTitle() {
		try {
			wait = new WebDriverWait(driver, 10);
			return driver.findElement(getFPageTitle);
		} catch (Exception e) {
			System.out.println("Locator"+e+ "was not found");
		}
		return null;
	}
	
}

	
