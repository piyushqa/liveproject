package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PagesMIPS;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class MIPSTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions action;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Parameters({ "baseURL", "username", "password" })
//	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
//	public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
//		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
//		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
//		PgLogin pgLogin = new PgLogin(driver);
//		try {
//			if (pgOpenStatus) {
//				lclPgLanding = pgLogin.validLogin(usrnm, pwd);
//				Reporter.log("Logged Successfully!");
//			}
//		} catch (Exception ex) {
//			Reporter.log(ex.toString());
//		}
//	}

	@Test(priority = 1)
	public void checkMips() throws InterruptedException, IOException {

		PagesMIPS mips = new PagesMIPS(driver, wait, action);
		mips.mipsDashboard();

	}

}
