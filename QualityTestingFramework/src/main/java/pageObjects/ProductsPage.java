package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

	public WebDriver driver;
	//ProductsPage Locators
	By getPrPageTitle = By.cssSelector(".product_label");
	By getBurgerBtn = By.cssSelector(".bm-burger-button");
	By getLogOutLink = By.cssSelector("#logout_sidebar_link");
	By getProduct = By.cssSelector(".inventory_item_name");
	By getAddCarBtn = By.xpath("//button[text()='ADD TO CART'] ");
	By getShopingCar = By.cssSelector("#shopping_cart_container > a > svg");
	
	
	//ProductsPage Constructor
	public ProductsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	//WebElement Methods
	public WebElement getTitlePage() {
		return driver.findElement(getPrPageTitle);
	}
	
	public WebElement getBtnBurger(){
		
		return driver.findElement(getBurgerBtn);
	}
	
	public WebElement getLogout(){
		return driver.findElement(getLogOutLink);
	}
	public List<WebElement> getProductsName(){
		return driver.findElements(getProduct);
	}
	
	public WebElement getAddCarButton(){
		return driver.findElement(getAddCarBtn);
	}
	
	public WebElement getShopCarBtn (){
		return driver.findElement(getShopingCar);
	}
}
