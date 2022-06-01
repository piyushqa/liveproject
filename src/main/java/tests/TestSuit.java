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
import pages.PgConfigBinocularPinhole;
import pages.PgCreatePatient;
import pages.PgDominantEyeCheck;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import pages.PgScheduleNewSurgery;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSuit {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	WebDriverWait wait;
	Actions action;
	PgScheduleNewSurgery pgScheduleObject;

	public static ExtentTest test;

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

	// Create Patient Test
	/*
	 * @Parameters({ "MRN", "PMSId", "FirstName", "LastName", "DOB", "SSN",
	 * "Gender", "Address1", "Address2", "City", "State", "ZipCode", "HomePhone",
	 * "WorkPhone", "CellPhone", "Email", "Medicare", "Medicaid", "Unknown",
	 * "Language", "Ethnicity", "Race", "Deceased", "OnlineAccess", "ContactMethod"
	 * })
	 *
	 * @Test(description = "Test to search for patient on Patient Search page",
	 * priority = 2, enabled = true, dataProvider = "patientDetails",
	 * dataProviderClass = TestDataProviders.class) public void
	 * tstCreatePatient(String mrn, String pmsid, String firstName, String lastName,
	 * String dob, String ssn, String gender, String address1, String address2,
	 * String city, String state, String zipCode, String homePhone, String
	 * workPhone, String cellPhone, String email, String medicare, String medicaid,
	 * String unknown, String language, String ethnicity, String deceased, String
	 * race, String onlineAccess, String contactMethod) throws Exception {
	 *
	 * lclpgCreatePatient = lclPgLanding.createPatient(); if
	 * (lclpgCreatePatient.createPatient(mrn, pmsid, firstName, lastName, dob, ssn,
	 * gender, address1, address2, city, state, zipCode, homePhone, workPhone,
	 * cellPhone, email, Boolean.parseBoolean(medicare),
	 * Boolean.parseBoolean(medicaid), Boolean.parseBoolean(unknown), language,
	 * ethnicity, Boolean.parseBoolean(deceased), race,
	 * Boolean.parseBoolean(onlineAccess), contactMethod)) {
	 * Reporter.log("Patient Saved successfully!"); } else {
	 * Reporter.log("Unable to Save the Patient"); } }
	 */

	// test to schedule new surgery

/*	@Parameters({ "First Name", "Last Name", "Favorites Categories", "Schedule Surgery", "Which Eye or Side?",
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

		// search patient
		Thread.sleep(4 * 1000);
		boolean editPatient = false;

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

	}*/

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

	// TestBinoCularPinHole
	@Parameters({ "FirstName", "LastName", "Provider", "Vision", "Binocular1Status", "Pinhole1Status",
			"Binocular2Status", "Pinhole2Status" })
	@Test(priority = 3, enabled = true, dataProvider = "ConfigBinocularPinholeDetails", dataProviderClass = TestDataProviders.class)
	public void testConfigureBincoularPinhole(String fName, String lName, String provider, String vision,
			String binocular1Status, String pinHole1Status, String binocular2Status, String pinHole2Status)
			throws Exception {
		{
			// call patientSearch method
			Thread.sleep(2000);

			boolean editPatient = false;
			lclPgPatientSearch = lclPgLanding.patientSearch();
			lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
			Thread.sleep(2000);
			PgConfigBinocularPinhole binocularPinhole = new PgConfigBinocularPinhole(driver, wait, action);
			binocularPinhole.configureBinocularPinhole(fName, lName, provider, vision, binocular1Status, pinHole1Status,
					binocular2Status, pinHole2Status);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"gwt-debug-returnToUserDashboard\"]")).click();
		}
	}

}
