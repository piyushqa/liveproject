package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pages.PgPatientDashboard;
import pages.PgPatientEncounter;
import pages.PgPatientSearch;
import pages.PgVisionTab;
import utilities.SetUp;
import utilities.TestDataProviders;

public class EncounterStartTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	public void tstLogin(String baseURL, String usrnm, String pwd) throws Exception {
		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
		PageLogIn pgLogin = new PageLogIn(driver);	try {
			if (pgOpenStatus) {
				lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}
	}

	@Parameters({ "FirstName", "LastName" })
	@Test(description = "Test to search for patient on Patient Search page", priority = 2, enabled = true, dataProvider = "getDetailsForPatientSearch", dataProviderClass = TestDataProviders.class)
	public void tstSearchPatient(String searchPatientFName, String searchPatientLName) throws Exception {
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "", editPatient);
	}

	@Test(description = "Starting a new encounter with searched patient", priority = 3, enabled = true)
	public void tstStartEncounter() throws Exception {
		PgPatientDashboard pgPatDashboard = new PgPatientDashboard(driver);
		PgPatientEncounter pgPatEnc = pgPatDashboard.startEncounter();
		PgVisionTab pgVision = pgPatEnc.entrVision();
		pgVision.addVA();

		Thread.sleep(3 * 1000);
		By addNewExistingGlassesLink = By.cssSelector("#gwt-debug-glasses-addNew");
		ensureElementToBeClickable(addNewExistingGlassesLink);
		driver.findElement(addNewExistingGlassesLink).click();
		pgVision.addExistingGlasses();

		Thread.sleep(3 * 1000);
		By addNewRefractionsLink = By.cssSelector("#gwt-debug-refraction-addNew");
		ensureElementToBeClickable(addNewRefractionsLink);
		driver.findElement(addNewRefractionsLink).click();
		pgVision.addRefractions();

		Thread.sleep(3 * 1000);
		By addNewContactLensLink = By.cssSelector("#gwt-debug-addNewContactLens");
		ensureElementToBeClickable(addNewContactLensLink);
		driver.findElement(addNewContactLensLink).click();
		pgVision.addContactLens();

	}

	@Test(description = "Starting a new encounter with searched patient", priority = 4, enabled = true)
	public void tstJoinEncounter() throws Exception {
		PgPatientDashboard pgPatDashboard = new PgPatientDashboard(driver);
		PgPatientEncounter pgPatEnc = pgPatDashboard.joinOpenEncounter(1);
		PgVisionTab pgVision = pgPatEnc.entrVision();
		pgVision.importExistingGlasses();
		pgVision.importRefractions();
	}

	@AfterTest
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
