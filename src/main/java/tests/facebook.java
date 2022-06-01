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
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ExtentTestManager;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class facebook {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;
	ExtentTest test1;
	ExtentTestManager manager = null;

	@BeforeTest
	
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/"
				+ "Users/win-0/Desktop/chromedriver_win32 (1)/chromedriver.exe");
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// ExtentReports report=new ExtentReports("./test-output/");

	}

	@Parameters({ "Enviorment", "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true)
	public void testLogin(String enviorment, String baseURL, String usrnm, String pwd) throws Exception {
		
		// public void testLogin() throws Exception {
		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		// boolean pgOpenStatus = lsetup.getPage(driver, ProjectSettings.baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");

		PageLogIn pgLogin = new PageLogIn(driver);
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
//		 manager = new ExtentTestManager(driver, manager);
//		 ExtentTestManager.getTest().setDescription("Add immunization data and download report");
		driver.close();
	}

}
