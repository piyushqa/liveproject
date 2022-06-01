
package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageLogIn;
import pages.PgAdvanceSearch;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import pages.PgScheduleNewSurgery;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AdvanceSearchTest {
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
	PgScheduleNewSurgery pgScheduleObject;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		action = new Actions(driver);
	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	public void tstLogin(String baseURL, String usrnm, String pwd) throws Exception {
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

	//advanceSearchDetails
	@Parameters({ "AddCriteria", "Gender","Relationship","SelectGender" })

	@Test(priority = 2, enabled = true, dataProvider = "AdvanceSearchDetails", dataProviderClass = TestDataProviders.class)
	void testConfigureClinicalDesicion(String addCriteria, String gender,String relationsShip,String selectGender) throws Exception {
		Thread.sleep(2000);
		PgAdvanceSearch advsrch = new PgAdvanceSearch(driver, wait, action);
		//call method addserachCriteria
		advsrch.addSerachCriteria(addCriteria, Boolean.parseBoolean(gender),relationsShip,selectGender);

	}

}
