package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageDeleteSurgerySchedule;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestDeleteSurgerySchedule {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;
	SetUp lsetUp = new SetUp();
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "Favorites Categories", "Schedule Surgery",
			"Which Eye or Side?", "Associate Procedure with a Problem", "Category of Surgery", "Comanaging",
			"Staged procedure", "Related surgery by same surgeon", "Unrelated surgery by same surgeon",
			"Repeat surgery by same surgeon", "Repeat surgery by different surgeon", "Location of Surgery", "When",
			"Anesthesia", "Surgeon", "Assistant Surgeon", "Preliminary planning of surgery complete", "SurgeryDate",
			"SurgeryTime", "Select Lab Tests", " Comments", " Associate Lab with a Problem", "Designate a Time",
			"Patient Notified", "Comments1", "Consent Form", "IOL Selection", "LRI Selection", "Patient Instructions",
			"Day Surgery Orders", "Prescriptions Given", "Sample Meds Given", "Pre-op Orders", "Pre-op Complete" })
	@Test(description = "In this test cases we edit the surgery module if any surgey module not avilable then we add", priority = 1, enabled = true, dataProvider = "DeleteSurgerySchedulePatientDetails", dataProviderClass = TestDataProviders.class)
	public void checkDeleteSurgeryModule(String enviorment, String fName, String lName, String provider,
			String favCategories, String scheduleSurgery, String whichEye, String associateProWithProblem,
			String categoryOfSurgery, String comanaging, String stagedProcedure, String relatedSurgeryBySameSurgeon,
			String unrelatedtSurgeryBySameSurgeon, String repeatSurgeryBySameSurgeon, String repeatSurgeryByDiffSurgeon,
			String locationOsSurgery, String when, String anesthesia, String surgeon, String assistantSurgeon,
			String preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, String patientNotify, String comment1,
			String consentForm, String iOLSelection, String lRISelection, String patientInstructions,
			String daySurgeryOrders, String prescriptionsGiven, String sampleMedsGiven, String preopOrders,
			String preOpComplete) throws Exception {
		// login to application
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// search the patient
		Thread.sleep(2000);
		Boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		// invoke verifyDeleteSurgeryModule
		new PageDeleteSurgerySchedule(driver, wait, builder).verifyDeleteSurgerySchedule(provider, favCategories,
				scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery, Boolean.parseBoolean(comanaging),
				Boolean.parseBoolean(stagedProcedure), Boolean.parseBoolean(relatedSurgeryBySameSurgeon),
				Boolean.parseBoolean(unrelatedtSurgeryBySameSurgeon), Boolean.parseBoolean(repeatSurgeryBySameSurgeon),
				Boolean.parseBoolean(repeatSurgeryByDiffSurgeon), locationOsSurgery, when, anesthesia, surgeon,
				assistantSurgeon, Boolean.parseBoolean(preliminaryPlanningOfSurgeryComplete), surgeryDate, surgeryTime,
				selectLabTest, comment, associateLabWithProblem, designateTime, Boolean.parseBoolean(patientNotify),
				comment1, Boolean.parseBoolean(consentForm), Boolean.parseBoolean(iOLSelection),
				Boolean.parseBoolean(lRISelection), Boolean.parseBoolean(patientInstructions),
				Boolean.parseBoolean(daySurgeryOrders), Boolean.parseBoolean(prescriptionsGiven),
				Boolean.parseBoolean(sampleMedsGiven), Boolean.parseBoolean(preopOrders),
				Boolean.parseBoolean(preOpComplete));
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
