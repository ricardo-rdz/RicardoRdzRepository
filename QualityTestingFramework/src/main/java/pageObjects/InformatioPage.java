package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformatioPage {

	public WebDriverWait wait;
	public WebDriver driver;
	// ProductsPage Locators
	By getYIPageTitle = By.cssSelector(".subheader");
	By getFirstNInput = By.cssSelector("#first-name");
	By getSecondNInput = By.cssSelector("#last-name");
	By getZipCInput = By.cssSelector("#postal-code");
	By getContinueBtn = By.xpath("//*[@value = 'CONTINUE']");
	By getErrorBtn = By.cssSelector(".error-button");

	
	
	// informationPage Constructor
	public InformatioPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	// WebElement Methods
	public WebElement getTitleIPPage() {
		try {
			wait = new WebDriverWait(driver, 10);
			return driver.findElement(getYIPageTitle);
		} catch (Exception e) {
			System.out.println("Locator"+e+ "was not found");
		}
		return null;
	}

	public WebElement getFirstName() {

		return driver.findElement(getFirstNInput);
	}

	public WebElement getSecondName() {
		wait = new WebDriverWait(driver, 10);
		return driver.findElement(getSecondNInput);
	}

	public WebElement getZipcode() {
		wait = new WebDriverWait(driver, 10);
		return driver.findElement(getZipCInput);
	}

	public WebElement getConBtn() {
		wait = new WebDriverWait(driver, 10);
		return driver.findElement(getContinueBtn);
	}

	public WebElement getErrorInfo() {
		wait = new WebDriverWait(driver, 10);
		return driver.findElement(getErrorBtn);
	}
}
