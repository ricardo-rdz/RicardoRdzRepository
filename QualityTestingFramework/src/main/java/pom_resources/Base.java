package pom_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Base {

	public WebDriver driver;
	public Properties prop;

	// method to select the browser to use
	public WebDriver initializeBrowser() throws IOException {

		prop = new Properties();
		FileInputStream fil = new FileInputStream("./src/main/resources/properties/data.properties");

		prop.load(fil);
		String browserName = prop.getProperty("browser");

		
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "./src/main/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public void getScreenshot(String result)throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result +"Screenshot.png"));
	}

}
