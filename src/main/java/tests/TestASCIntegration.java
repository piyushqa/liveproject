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
import pages.PageASCIntegration;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestASCIntegration {

	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	Actions builder;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorments", "FirstName", "LastName" })
	@Test(description = "In this secnario we check ASC integration", priority = 1, enabled = true, dataProvider = "ASCIntegrationDetails", dataProviderClass = TestDataProviders.class)
	public void checkASCIntegration(String enviorment, String fName, String lName) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageASCIntegration(wait, driver, builder).verifyASCIntegration(fName, lName);

	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
