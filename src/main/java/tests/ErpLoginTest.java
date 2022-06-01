package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.ErpLogInPage;
import pages.PageLogIn;
import pages.PgErpLanding;
import pages.PgLanding;
import utilities.ExtentTestManager;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class ErpLoginTest {
	
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgErpLanding lclPgLanding;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;
	ExtentTest test1;
	ExtentTestManager manager = null;

	@BeforeTest

	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// ExtentReports report=new ExtentReports("./test-output/");

	}

	@Parameters({ "Enviorment", "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "ERPLoginCredentials", dataProviderClass = TestDataProviders.class)
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true)
	public void testErpLogin(String enviorment, String baseURL, String usrnm, String pwd) throws Exception {
		// manager = new ExtentTestManager(driver, manager);
		// ExtentTestManager.getTest().setDescription("Add immunization data and
		// download report");
		// public void testLogin() throws Exception {
		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		// boolean pgOpenStatus = lsetup.getPage(driver, ProjectSettings.baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");

		ErpLogInPage pgLogin = new ErpLogInPage(driver);
		try {
			if (pgOpenStatus) {
				lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
				// lclPgLanding = pgLogin.validLogin();
				Thread.sleep(2000);
				shot = new ScreenShot();
				ScreenShot.screen(driver);
				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}

	}

	@AfterTest
	public void logout() {
		driver.close();
	}


}
