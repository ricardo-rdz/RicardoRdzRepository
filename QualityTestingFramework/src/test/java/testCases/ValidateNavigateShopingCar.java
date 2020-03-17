package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ShopingCarPage;
import pom_resources.Base;
import pom_resources.DataProviderClass;

public class ValidateNavigateShopingCar extends Base {

	public List itemsAdded ;
	public Properties prop;
	public LoginPage lp;
	public ProductsPage pp;
	public ShopingCarPage sc;

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeBrowser();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

	}

	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)
	public void navigatetoShopCarPage(String UserID, String Password) {

		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
		sc = new ShopingCarPage(driver);

		if (lp.getUserName().isDisplayed()) {
			lp.getUserName().sendKeys(UserID);
			lp.getPassword().sendKeys(Password);
			lp.getLoginBtn().submit();
		}
		pp.getShopCarBtn().click();

		AssertJUnit.assertEquals(sc.getTitleSCPage().getText(), "Your Cart");
		System.out.println("4th validation: The User navigates to " + sc.getTitleSCPage().getText() + " Page");
	}

	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)

	public void selectOneProduct(String UserID, String Password) throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
		sc = new ShopingCarPage(driver);

		prop = new Properties();
		FileInputStream fil = new FileInputStream("./src/main/resources/properties/products.properties");
		prop.load(fil);
		String item = prop.getProperty("prod1");

		if (lp.getUserName().isDisplayed()) {
			lp.getUserName().sendKeys(UserID);
			lp.getPassword().sendKeys(Password);
			lp.getLoginBtn().submit();
		}

		List<WebElement> products = pp.getProductsName();

		for (int i = 0; i < products.size(); i++)

		{
			String prodName = products.get(i).getText();
			if (prodName.contains(item)) {
				pp.getAddCarButton().click();
				break;
			}

		}
		pp.getShopCarBtn().click();

		AssertJUnit.assertEquals(sc.getAddedItemName().getText(), item);
		System.out.println("5th validation: The User navigates to " + sc.getTitleSCPage().getText() + " Page and added "
				+ sc.getAddedItemName().getText() + " product");
	}

	
	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)
	public void selectMutipleProducts(String UserID, String Password) throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
		sc = new ShopingCarPage(driver);

		prop = new Properties();
		FileInputStream fil = new FileInputStream("./src/main/resources/properties/products.properties");
		prop.load(fil);
		String[] item = {prop.getProperty("firstName1"),prop.getProperty("secondName1"), prop.getProperty("zip1")};
		
		
		if (lp.getUserName().isDisplayed()) {
			lp.getUserName().sendKeys(UserID);
			lp.getPassword().sendKeys(Password);
			lp.getLoginBtn().submit();
		}

		List<WebElement> products = pp.getProductsName();

		for (int i = 0; i < products.size(); i++)

		{
			String prodName = products.get(i).getText();
			 itemsAdded = Arrays.asList(item);
			
			if (itemsAdded.contains(prodName)) {
				pp.getAddCarButton().click();
				
			}

		}
		pp.getShopCarBtn().click();

		
		
		List<WebElement> productsAdded = sc.getItemsName();
		
		for (int j =0; j<productsAdded.size(); j++){
			
			String prodAdded =productsAdded.get(j).getText();
			
			
			System.out.println("6th validation: User Added "+ prodAdded + " product");
			AssertJUnit.assertEquals(prodAdded, prodAdded);
						
		}
		
		
		
		
	}

	@AfterMethod

	public void close() {
		driver.close();
	}
}
