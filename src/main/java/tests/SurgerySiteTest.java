package tests;

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
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import pages.PgSurgerySite;
import utilities.SetUp;
import utilities.TestDataProviders;

public class SurgerySiteTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;
	Actions action;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
		PageLogIn pgLogin = new PageLogIn(driver);
		try {
			if (pgOpenStatus) {
				lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}
	}

	@Parameters({ "SelectSite", "ConfigrationOptions", "Name", "Address Line1", "Address Line2", "City", "State", "ZIP",
			"Website", "PMSId" })
	@Test(priority = 2, dataProvider = "SurgerySitetDetails", dataProviderClass = TestDataProviders.class)
	public void testSurgerySite(String selectSite, String configrationoptions, String name, String addressLine1,
			String addressline2, String city, String state, String zip, String website, String pmsId) throws Exception {
		Thread.sleep(2000);
		PgSurgerySite s1 = new PgSurgerySite(driver, wait, action);
		s1.addSurgerySite(selectSite, configrationoptions, name, addressLine1, addressline2, city, state, zip, website,
				pmsId);
		s1.addAnotherSurgeryData(name, addressLine1, addressline2, city, state, zip, website, pmsId);
	    //s1.xlsheetData();

	}

}
