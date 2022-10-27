package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilites.Helper;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "/Downloads";
	
	public static FirefoxOptions firefoxOption() 
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("broswer.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream");
		option.addPreference("browser.download.manger.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("fireFox") String browserName) 
	{
		if (browserName.equalsIgnoreCase("fireFox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxOption());
		}
		else if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("chrome-headless")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com");
	}

	
	@AfterSuite
	public void stopDriver() 
	{
		driver.quit();
	}
	
	// take screenshot when test case fail and add it in the folder Screenshots
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshots....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
