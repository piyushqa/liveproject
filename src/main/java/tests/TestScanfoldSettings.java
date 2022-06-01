package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageScanfoldSettings;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestScanfoldSettings {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	SetUp lsetUp = new SetUp();
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "C://BrowserDriver//chromedriver.exe");
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorments","FirstName","LastName"})
	@Test(description = "Perform scanfold operation", priority = 1, enabled = true, dataProvider = "ScanfoldSettingsDetails", dataProviderClass = TestDataProviders.class)
	public void checkScanfoldSettings(String enviorment,String fName,String lName) throws Exception {
		LoginTest test=new LoginTest(driver);
		test.testLogin();
		
		new PageScanfoldSettings(driver, wait, builder).verifyScanfoldSettings(fName,lName);
	}
	
//	@AfterTest
//	public void logOut()
//	{
//		driver.close();
//	}
}
