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
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import pages.PgPendingPatient;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestPendingPatient {

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
	public ScreenShot shot;

	@BeforeTest
	@Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, groups = {
			"logInAlways" }, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
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

	// This test check the pending patient
	@Parameters({ "FirstName", "LastName", "Provider", "Category", "subCategory", "subCategory1", "Eye",
			"Glaucoma Severity", "Glaucoma Stability", "Name", "TextInput", "Recipites" })
	@Test(description = "This test check the pending patient", priority = 2, enabled = true,groups= {"runAlwaysAfterLogin"} , dataProvider = "PendingPatientDetails", dataProviderClass = TestDataProviders.class)
	public void checkPendingpatient(String fName, String lName, String provider, String category, String subCategory,
			String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability, String name,
			String textInput, String recipites) throws Exception {

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PgPendingPatient pendingPatient = new PgPendingPatient(driver, wait);
		pendingPatient.createPendingPatient(provider, category, subCategory, subCategory1, eye, glaucomaSeverity,
				glaucomaStability, name, textInput, recipites);


	}
	//
	// //close the driver
	// @AfterTest
	// public void logOut() {
	// driver.close();
	// }
}
