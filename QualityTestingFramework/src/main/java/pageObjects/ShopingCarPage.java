package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopingCarPage {

	public WebDriver driver;
	//ProductsPage Locators
	By getSCPageTitle = By.cssSelector(".subheader");
	By getItemName = By.cssSelector(".inventory_item_name");
	By getItemsAddedName = By.cssSelector(".inventory_item_name");
	By getChkBttn = By.cssSelector(".btn_action.checkout_button");
	
	
	
	//ProductsPage Constructor
	public ShopingCarPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	//WebElement Methods
	public WebElement getTitleSCPage() {
		return driver.findElement(getSCPageTitle);
	}
	
	public WebElement getAddedItemName (){
		return driver.findElement(getItemName);
	}
	
	public List<WebElement> getItemsName(){
		return driver.findElements(getItemsAddedName);
	}
	public WebElement getChkOutBtn() {
		return driver.findElement(getChkBttn);
	}
}
