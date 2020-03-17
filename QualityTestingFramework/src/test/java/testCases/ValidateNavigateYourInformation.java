package testCases;

import org.testng.annotations.Test;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.InformatioPage;
import pageObjects.LoginPage;
import pageObjects.OverViewPage;
import pageObjects.ProductsPage;
import pageObjects.ShopingCarPage;
import pom_resources.Base;
import pom_resources.DataProviderClass;

public class ValidateNavigateYourInformation extends Base {

	public OverViewPage op;
	public InformatioPage ip;
	public List itemsAdded;
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

	public void verifyErrorMessage(String UserID, String Password) throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
		sc = new ShopingCarPage(driver);
		ip = new InformatioPage(driver);

		prop = new Properties();
		FileInputStream fil = new FileInputStream("./src/main/resources/properties/userInfo.properties");
		prop.load(fil);
		FileInputStream fil2 = new FileInputStream("./src/main/resources/properties/products.properties");
		prop.load(fil2);
		String item = prop.getProperty("prod1");
		String name = prop.getProperty("firstName1");
		String secondName = prop.getProperty("secondName1");
		String zip = prop.getProperty("zip1");

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
		sc.getChkOutBtn().click();

		if (ip.getTitleIPPage().isDisplayed()) {
			ip.getFirstName().sendKeys(name);
			ip.getSecondName().sendKeys(secondName);
			ip.getZipcode().sendKeys(zip);
			ip.getConBtn().click();
		}

		

		AssertJUnit.assertTrue(ip.getErrorInfo().isDisplayed());
		System.out.println("7th validation: The User verifies User Information Error Message");
	}

	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)

	public void verifyOverViewPage(String UserID, String Password) throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
		sc = new ShopingCarPage(driver);
		ip = new InformatioPage(driver);
		op =new OverViewPage(driver);

		prop = new Properties();
		FileInputStream fil = new FileInputStream("./src/main/resources/properties/userInfo.properties");
		prop.load(fil);
		FileInputStream fil2 = new FileInputStream("./src/main/resources/properties/products.properties");
		prop.load(fil2);
		String item = prop.getProperty("prod1");
		String name = prop.getProperty("firstName2");
		String secondName = prop.getProperty("secondName2");
		String zip = prop.getProperty("zip2");

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
		sc.getChkOutBtn().click();

		if (ip.getTitleIPPage().isDisplayed()) {
			ip.getFirstName().sendKeys(name);
			ip.getSecondName().sendKeys(secondName);
			ip.getZipcode().sendKeys(zip);
			ip.getConBtn().click();
		}

		
		AssertJUnit.assertTrue(op.getTitleOVPage().isDisplayed());
			System.out.println("8th validation: User Navigates to "+op.getTitleOVPage().getText()+" Page");
	}

	@AfterMethod

	public void close() {
		driver.close();
	}
}
