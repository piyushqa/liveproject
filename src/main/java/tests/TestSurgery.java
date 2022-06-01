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
import pages.PgSurgery;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSurgery {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;;

	@BeforeTest
	// @Test(groups = { "logInAlways" })
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Parameters({ "baseURL", "username", "password" })
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true, groups = {
	// "logInAlways" }, dataProvider = "LoginCredentials", dataProviderClass =
	// TestDataProviders.class)
	// public void testLogin(String baseURL, String usrnm, String pwd) throws
	// Exception {
	// boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
	// Reporter.log(ProjectSettings.baseURL + " opened successfully.");
	// PageLogIn pgLogin = new PageLogIn(driver);
	// try {
	// if (pgOpenStatus) {
	// lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
	// Reporter.log("Logged Successfully!");
	// }
	// } catch (Exception ex) {
	// Reporter.log(ex.toString());
	// }
	// }

	// This test check the Surgery patient
	@Parameters({ "Enviorment", "FirstName", "LastName", "Favorites Categories", "Schedule Surgery",
			"Which Eye or Side?", "Associate Procedure with a Problem", "Category of Surgery", "Procedure Time",
			"Comanaging", "Staged procedure", "Related surgery by same surgeon", "Unrelated surgery by same surgeon",
			"Repeat surgery by same surgeon", "Repeat surgery by different surgeon", "Location of Surgery", "When",
			"Anesthesia", "Surgeon", "Assistant Surgeon", "Preliminary planning of surgery complete", "SurgeryDate",
			"SurgeryTime", "Select Lab Tests", " Comments", " Associate Lab with a Problem", "Designate a Time",
			"Patient Notified", "Comments1", "Consent Form", "IOL Selection", "LRI Selection", "Patient Instructions",
			"Day Surgery Orders", "Prescriptions Given", "Sample Meds Given", "Pre-op Orders", "OpNoteText",
			"OpNoteLiberary", "ContractSurgery", "Pre-op Complete", "DataListItem" })
	@Test(description = "This test check the Surgery patient", priority = 2, enabled = true, dataProvider = "SurgeryPatientDetails", dataProviderClass = TestDataProviders.class)
	public void checkScheduledSurgeryPatient(String enviorment, String fName, String lName, String favCategories,
			String scheduleSurgery, String whichEye, String associateProWithProblem, String categoryOfSurgery,
			String procedureTime, String comanaging, String stagedProcedure, String relatedSurgeryBySameSurgeon,
			String unrelatedtSurgeryBySameSurgeon, String repeatSurgeryBySameSurgeon, String repeatSurgeryByDiffSurgeon,
			String locationOsSurgery, String when, String anesthesia, String surgeon, String assistantSurgeon,
			String preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, String patientNotify, String comment1,
			String consentForm, String iOLSelection, String lRISelection, String patientInstructions,
			String daySurgeryOrders, String prescriptionsGiven, String sampleMedsGiven, String preopOrders,
			String opNoteText, String opNoteLiberary, String ContractSurgery, String preOpComplete, String dataListItem)
			throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Thread.sleep(3000);
		lclPgLanding = new PgLanding(driver);
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		PgSurgery testSurgery = new PgSurgery(driver, wait,builder);
		testSurgery.surgeryPatient(favCategories, scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery,
				procedureTime, Boolean.parseBoolean(comanaging), Boolean.parseBoolean(stagedProcedure),
				Boolean.parseBoolean(relatedSurgeryBySameSurgeon), Boolean.parseBoolean(unrelatedtSurgeryBySameSurgeon),
				Boolean.parseBoolean(repeatSurgeryBySameSurgeon), Boolean.parseBoolean(repeatSurgeryByDiffSurgeon),
				locationOsSurgery, when, anesthesia, surgeon, assistantSurgeon,
				Boolean.parseBoolean(preliminaryPlanningOfSurgeryComplete), surgeryDate, surgeryTime, selectLabTest,
				comment, associateLabWithProblem, designateTime, Boolean.parseBoolean(patientNotify), comment1,
				Boolean.parseBoolean(consentForm), Boolean.parseBoolean(iOLSelection),
				Boolean.parseBoolean(lRISelection), Boolean.parseBoolean(patientInstructions),
				Boolean.parseBoolean(daySurgeryOrders), Boolean.parseBoolean(prescriptionsGiven),
				Boolean.parseBoolean(sampleMedsGiven), Boolean.parseBoolean(preopOrders), opNoteText, opNoteLiberary,
				ContractSurgery, Boolean.parseBoolean(preOpComplete), dataListItem);
		Thread.sleep(2000);
		ScreenShot src = new ScreenShot();
		ScreenShot.screen(driver);
	}

	// close the driver
	@AfterTest
	public void logOut() {
		driver.close();
	}
}
