package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import pages.PgDominantEyeCheck;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;

import utilities.SetUp;
import utilities.TestDataProviders;

public class DominantEyeCheckTest {
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


	//testDominantEyeFunction
	@Parameters({ "FirstName", "LastName", "Provider", "Vision", "DominantEye" })
	@Test(priority = 2, enabled = true, dataProvider = "DominantEyeDetails", dataProviderClass = TestDataProviders.class)
	public void testDominantEye(String fName, String lName, String provider, String vision, String dominantEye) throws Exception {
		{
			// call patientSearch method
			Thread.sleep(2000);

			boolean editPatient = false;
			lclPgPatientSearch = lclPgLanding.patientSearch();
			lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
			Thread.sleep(2000);

			//call PgDominantEyeCheck method from pages class
			PgDominantEyeCheck eyeCheck=new PgDominantEyeCheck(driver, wait, action);
			eyeCheck.dominantEyeCheck(fName,lName,provider,vision,dominantEye);
		}

	}

}
