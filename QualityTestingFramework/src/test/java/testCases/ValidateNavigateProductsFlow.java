package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pom_resources.Base;
import pom_resources.DataProviderClass;

public class ValidateNavigateProductsFlow extends Base {
	
	public LoginPage lp;
	public ProductsPage pp;

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeBrowser();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}

	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)
	public void loginPrdPg(String UserID, String Password) {

		 lp = new LoginPage(driver);
		 pp = new ProductsPage(driver);
		if (lp.getUserName().isDisplayed()) {
			lp.getUserName().sendKeys(UserID);
			lp.getPassword().sendKeys(Password);
			lp.getLoginBtn().submit();

			AssertJUnit.assertEquals(pp.getTitlePage().getText(), "Products");
			System.out.println("1st validation: The User navigates to " + pp.getTitlePage().getText() + " Page");
		}
	}

	@Test(dataProvider = "wrongData", dataProviderClass = DataProviderClass.class)
	public void loginWrongUser(String UserID, String Password) {

		lp = new LoginPage(driver);
		if (lp.getUserName().isDisplayed()) {
			lp.getUserName().sendKeys(UserID);
			lp.getPassword().sendKeys(Password);
			lp.getLoginBtn().submit();

			AssertJUnit.assertTrue(lp.getErrorMs().isDisplayed());
			System.out.println("2nd validation: The User navigates with wrong userName ");
		}
	}

	@Test(dataProvider = "authenticationData", dataProviderClass = DataProviderClass.class)
	public void logoutPrdPg(String UserID, String Password) {

		 lp = new LoginPage(driver);
		 pp = new ProductsPage(driver);

		if (lp.getUserName().isDisplayed()) {
			lp.getUserName().sendKeys(UserID);
			lp.getPassword().sendKeys(Password);
			lp.getLoginBtn().submit();

		} else {
			System.out.println("Element not foud");
		}

		if (pp.getBtnBurger().isDisplayed()) {
			pp.getBtnBurger().click();
			pp.getLogout().click();

			AssertJUnit.assertTrue(lp.getSwagTittle().isDisplayed());
		}

		System.out.println("3rd validation: The User navigates to Products Page and Go back to Login Page");
	}

	@AfterMethod

	public void close() {
		 driver.close();
	}
}
