package testCases;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.FinishPage;
import pageObjects.InformatioPage;
import pageObjects.LoginPage;
import pageObjects.OverViewPage;
import pageObjects.ProductsPage;
import pageObjects.ShopingCarPage;
import pom_resources.Base;
import pom_resources.DataProviderClass;

public class ValidateNavigateOverView extends Base {

	public FinishPage fp;
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

		
		
		Assert.assertEquals(op.getItemName().getText(), sc.getAddedItemName().getText());
			System.out.println("9th validation: User Navigates to "+op.getTitleOVPage().getText()+" Page and Verify "+op.getItemName().getText()+"Product matches Product added");
	}
	
	
	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)

	public void verifyFinishPage(String UserID, String Password) throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
		sc = new ShopingCarPage(driver);
		ip = new InformatioPage(driver);
		op =new OverViewPage(driver);
		fp =new FinishPage(driver);

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
		
		if(op.getFshBtn().isDisplayed()){
			op.getFshBtn().click();
		}
		
		
		Assert.assertTrue(fp.getFinishMessage().isDisplayed());
			System.out.println("10th validation: User navigates to"+fp.getFinishPTitle().getText()+" Page");
	}
	
	

	@AfterMethod

	public void close() {
		driver.close();
	}
}
