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
import pages.PgAddEyeHistoryValues;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AddingEyeHistoryValuesTest {

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

	@Parameters({ "FirstName", "LastName" })
	@Test(description = "Test to search for patient on Patient Search page", priority = 2, enabled = true, dataProvider = "getDetailsForPatientSearch", dataProviderClass = TestDataProviders.class)
	public void tstSearchPatient(String searchPatientFName, String searchPatientLName) throws Exception {
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "", editPatient);
	}

	@Parameters({"EncounterDate", "Type", "HistoryCatagory1", "HistoryCatagory2", "HistoryCatagory3", "HistoryCatagory4", "Time", "TimeType"})
	@Test(description = "Test to add Past Eye Problem", priority = 3, dataProvider = "eyeHistoryValue", dataProviderClass = TestDataProviders.class)
	public void addEyeHistoryValue(String encounterDate, String type, String historyCatagory1, String historyCatagory2, String historyCatagory3, String historyCatagory4, String time, String timeType) throws Exception {
		PgAddEyeHistoryValues pgAddEyeHistoryValues = new PgAddEyeHistoryValues(driver, wait, action);
		switch (type) {
		case "PAST_EYE_PROBLEM":
			pgAddEyeHistoryValues.addPastEyeProblem(encounterDate, historyCatagory1, historyCatagory2, historyCatagory3, historyCatagory4, time, timeType);
			break;
		case "PRIOR_EYE_SURGERY":
			pgAddEyeHistoryValues.addPriorEyeSurgery(encounterDate, historyCatagory1, historyCatagory2, historyCatagory3, historyCatagory4, time, timeType);
			break;
		case "OCULAR_MEDICATIONS":
			pgAddEyeHistoryValues.addOcularMedications(encounterDate, historyCatagory1, historyCatagory2, historyCatagory3, historyCatagory4, time, timeType);
			break;
		case "TODAY_EXAM":
			pgAddEyeHistoryValues.addTodayExamValue(encounterDate, historyCatagory1, historyCatagory2, historyCatagory3, historyCatagory4, time, timeType);
			break;
		default:
			throw new Exception("Type does not match any Problems");
		}
	}


	@AfterTest
	void closeDriver() {
		driver.quit();
	}
}
