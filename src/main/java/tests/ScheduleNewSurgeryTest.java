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
import pages.PgScheduleNewSurgery;
import utilities.SetUp;
import utilities.TestDataProviders;

public class ScheduleNewSurgeryTest {
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
		//action = new Actions(driver);
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

	// test to schedule new surgery

	@Parameters({ "First Name", "Last Name", "Favorites Categories", "Schedule Surgery", "Which Eye or Side?",
			"Associate Procedure with a Problem", "Category of Surgery", "Procedure Time", "Comanaging",
			"Staged procedure", "Related surgery by same surgeon", "Unrelated surgery by same surgeon",
			"Repeat surgery by same surgeon", "Repeat surgery by different surgeon", "Location of Surgery", "When",
			"Anesthesia", "Surgeon", "Assistant Surgeon", "Preliminary planning of surgery complete", "SurgeryDate",
			"SurgeryTime", "Select Lab Tests", " Comments", " Associate Lab with a Problem", "Designate a Time",
			"Patient Notified", "Comments1", "Consent Form", "IOL Selection", "LRI Selection", "Patient Instructions",
			"Day Surgery Orders", "Prescriptions Given", "Sample Meds Given", "Pre-op Orders" })
	@Test(description = "This test to scheduleNewSurgery", priority = 2, enabled = true, dataProvider = "scheduleNewSurgeryTestDetail", dataProviderClass = TestDataProviders.class)
	public void TestScheduleNewSurgery(String fname, String lName, String favCategories, String scheduleSurgery,
			String whichEye, String associateProWithProblem, String categoryOfSurgery, String procedureTime,
			String comanaging, String stagedProcedure, String relatedSurgeryBySameSurgeon,
			String unrelatedtSurgeryBySameSurgeon, String repeatSurgeryBySameSurgeon, String repeatSurgeryByDiffSurgeon,
			String locationOsSurgery, String when, String anesthesia, String surgeon, String assistantSurgeon,
			String preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, String patientNotify, String comment1,
			String consentForm, String iOLSelection, String lRISelection, String patientInstructions,
			String daySurgeryOrders, String prescriptionsGiven, String sampleMedsGiven, String preopOrders)
			throws Exception {
//		Thread.sleep(1000);
//		LoginTest test = new LoginTest(driver);
//		test.testLogin();
		// search patient
		Thread.sleep(2 * 1000);
		boolean editPatient = false;
		//lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fname, lName, "", editPatient);

		pgScheduleObject = new PgScheduleNewSurgery(driver, wait, action);
		pgScheduleObject.scheduleNewSurgeryMethod(favCategories, scheduleSurgery, whichEye, associateProWithProblem,
				categoryOfSurgery, procedureTime, Boolean.parseBoolean(comanaging),
				Boolean.parseBoolean(stagedProcedure), Boolean.parseBoolean(relatedSurgeryBySameSurgeon),
				Boolean.parseBoolean(unrelatedtSurgeryBySameSurgeon), Boolean.parseBoolean(repeatSurgeryBySameSurgeon),
				Boolean.parseBoolean(repeatSurgeryByDiffSurgeon), locationOsSurgery, when, anesthesia, surgeon,
				assistantSurgeon, Boolean.parseBoolean(preliminaryPlanningOfSurgeryComplete), surgeryDate, surgeryTime,
				selectLabTest, comment, associateLabWithProblem, designateTime, Boolean.parseBoolean(patientNotify),
				comment1, Boolean.parseBoolean(consentForm), Boolean.parseBoolean(iOLSelection),
				Boolean.parseBoolean(lRISelection), Boolean.parseBoolean(patientInstructions),
				Boolean.parseBoolean(daySurgeryOrders), Boolean.parseBoolean(prescriptionsGiven),
				Boolean.parseBoolean(sampleMedsGiven), Boolean.parseBoolean(preopOrders));

	}

	// @AfterTest
	// void closeDriver() {
	// driver.quit();
	// }
}
