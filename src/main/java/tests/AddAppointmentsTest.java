
package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageLogIn;
import pages.PgAddAppintments;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AddAppointmentsTest {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;
	Actions action;
	PgAddAppintments pgappoint;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Define visibility and clicAkble
	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Parameters({ "Provider", "ClinicSite", "Visit Type", "Status", "DateofAppointment", "TimeofAppointment",
			"FirstName", "LastName" })
	@Test(priority = 3, dataProvider = "AppointmentDetail", dataProviderClass = TestDataProviders.class)

	public void addAppointment(String env,String provider, String clinicsite, String visittype, String status,
			String dateofappointment, String timeofappointment, String searchPatientFName, String searchPatientLName)
			throws Exception {
		wait = new WebDriverWait(driver, 10, 500);
		By addAppointment = By.cssSelector("#gwt-debug-addAppointment > a");
		ensureElementToBeClickable(addAppointment);
		driver.findElement(addAppointment).click();
		wait = new WebDriverWait(driver, 10, 500);
		By clickOnSrch = By.id("gwt-debug-patientSearch");
		ensureElementToBeClickable(clickOnSrch);
		driver.findElement(clickOnSrch).click();

		boolean editPatient = false;

		lclPgPatientSearch = new PgPatientSearch(driver);
		lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "", editPatient);

		pgappoint = new PgAddAppintments(driver, wait, action);

		pgappoint.addAppointment(provider, clinicsite, visittype, status, dateofappointment, timeofappointment);

	}
}
