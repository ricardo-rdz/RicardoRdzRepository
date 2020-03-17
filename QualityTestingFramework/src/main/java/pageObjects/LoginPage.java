package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	//LoginPage Locators
	By getLgPageTitle = By.cssSelector(".login_logo");
	By userNameInput = By.cssSelector("#user-name");
	By passwordInput = By.cssSelector("#password");
	By loginButton = By.cssSelector(".btn_action");

	By getErrorBtn = By.cssSelector("button.error-button");

	
	//LoginPage Constructor
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	
	
	//WebElement Methods
	public WebElement getSwagTittle() {
		try {
			return driver.findElement(getLgPageTitle);

		} catch (Exception e) {
			System.out.println("Element" + e + "was not found");
		}
		return null;
	}

	public WebElement getUserName() {

		return driver.findElement(userNameInput);

	}

	public WebElement getPassword() {

		return driver.findElement(passwordInput);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginButton);
	}

	public WebElement getErrorMs() {
		return driver.findElement(getErrorBtn);
	}

}
