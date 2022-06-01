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
import pages.PgConfigBinocularPinhole;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestConfigBinocularPinhole {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;
	private Actions action;

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

	@Parameters({ "FirstName", "LastName", "Provider", "Vision", "Binocular1Status", "Pinhole1Status",
			"Binocular2Status", "Pinhole2Status" })
	@Test(priority = 2, enabled = true, dataProvider = "ConfigBinocularPinholeDetails", dataProviderClass = TestDataProviders.class)
	public void testConfigureBincoularPinhole(String fName, String lName, String provider, String vision,
			String binocular1Status, String pinHole1Status, String binocular2Status, String pinHole2Status)
			throws Exception {
		{
			// call patientSearch method
			Thread.sleep(2000);

			boolean editPatient = false;
			lclPgPatientSearch = lclPgLanding.patientSearch();
			lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
			Thread.sleep(2000);
			PgConfigBinocularPinhole binocularPinhole = new PgConfigBinocularPinhole(driver, wait, action);
			binocularPinhole.configureBinocularPinhole(fName, lName, provider, vision, binocular1Status, pinHole1Status,
					binocular2Status, pinHole2Status);

		}
	}

}
