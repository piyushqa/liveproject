package tests;

import java.util.Arrays;
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
import pages.PgAddCCAndHPIValues;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AddingCCAndHPIValuesTest {

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
	private PgAddCCAndHPIValues pgAddCCAndHPIValues;
	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		action = new Actions(driver);
		pgAddCCAndHPIValues = new PgAddCCAndHPIValues(driver, wait, action);
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

	@Parameters({ "FirstName", "LastName" })
	@Test(description = "Test to search for patient on Patient Search page", priority = 2, enabled = true, dataProvider = "getDetailsForPatientSearch", dataProviderClass = TestDataProviders.class)
	public void tstSearchPatient(String searchPatientFName, String searchPatientLName) throws Exception {
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "", editPatient);
	}

	@Parameters({"EncounterDate", "Type", "Values", "VisitType", "LastVisitDate", "LastVisitProviderFirstName", "LastVisitProviderLastName", "ReferingProviderFirstName", "ReferingProviderLastName", "ReferingProviderAssociation"})
	@Test(description = "Test to add CC and HPI value", priority = 3, dataProvider = "ccAndHPIValue", dataProviderClass = TestDataProviders.class)
	public void addValue(String encounterDate, String type, String values, String visitType, String lastVisitDate, String lastVisitProviderFirstName, String lastVisitProviderLastName, String referingProviderFirstName, String referingProviderLastName, String referingProviderAssociation) throws Exception {

		switch (type) {
		case "PAST_EYE_PROBLEM":
			pgAddCCAndHPIValues.addPastEyeProblem(encounterDate, Arrays.asList(values.split("\\s*,\\s*")));
			break;
		case "PRIOR_EYE_SURGERY":
			pgAddCCAndHPIValues.addPriorEyeSurgery(encounterDate, Arrays.asList(values.split("\\s*,\\s*")));
			break;
		case "OCULAR_MEDICATIONS":
			pgAddCCAndHPIValues.addOcularMedications(encounterDate, Arrays.asList(values.split("\\s*,\\s*")));
			break;
		case "TODAY_EXAM":
			pgAddCCAndHPIValues.addTodayExamValue(encounterDate, Arrays.asList(values.split("\\s*,\\s*")));
			break;
		default:
			throw new Exception("Type does not match any Problems");
		}
		pgAddCCAndHPIValues.addCCAndHPI(encounterDate, visitType, lastVisitDate, lastVisitProviderFirstName, lastVisitProviderLastName, referingProviderFirstName, referingProviderLastName, referingProviderAssociation);

	}

	@AfterTest
	private void close() {
		if (driver != null) {
			driver.quit();
		}
	}
}
