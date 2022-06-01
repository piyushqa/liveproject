
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
import pages.PageScheduleSurgeryWithAllCondition;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestScheduleSurgeryWithAllCondition {

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

	@Parameters({ "Enviorments", "FirstName", "LastName", "Favorites Categories", "Schedule Surgery",
			"Which Eye or Side?", "Associate Procedure with a Problem", "Category of Surgery", "yagLaser",
			"VisibleLightLaser", "Location of Surgery", "When", "Anesthesia", "Surgeon", "Assistant Surgeon",
			"SurgeryDate", "Preliminary planning of surgery complete", "Patient Notified", "Pre-op Complete",
			"Consent Form", "IOL Selection", "LRI Selection", "Patient Instructions", "Day Surgery Orders",
			"Prescriptions Given", "Sample Meds Given", "Pre-op Orders", "Drug", "Injection", "Location", "Needle",
			"shutRef", "iStentRef", "Axial-Acd", "Impresson", "AxisPlacement", "MethodK1", "RadiusK1", "Axisk1",
			"MethodK2", "RadiusK2", "AxisK2", "IOLCalCulationFormula", "PlannedIOL" })
	@Test(description = "In this test case we match all the condition of surgery and generate op note and match operative note data with op note data", priority = 1, enabled = true, dataProvider = "SurgeryWithAllConditionDetails", dataProviderClass = TestDataProviders.class)
	public void checkScheduleSurgeryWithAllCondition(String enviorment, String fName, String lName,
			String favCategories, String scheduleSurgery, String whichEye, String associateProWithProblem,
			String categoryOfSurgery, String yagLaser, String visibleLightLaser, String locationOfSurgery, String when,
			String anesthesia, String surgeon, String assistantSurgeon, String surgeryDate,
			String preliminaryPlanningOfSurgeryComplete, String patientNotify, String preOpComplete, String consentForm,
			String iOLSelection, String lRISelection, String patientInstructions, String daySurgeryOrders,
			String prescriptionsGiven, String sampleMedsGiven, String preopOrders, String drug, String injection,
			String location, String needle, String shutRef, String iStentRef, String axilAcd, String impression,
			String axisPlacement, String methodK1, String radiusk1, String axisk1, String methodK2, String radiusk2,
			String axisk2, String IOLCalCulationFormula, String PlannedIOL) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageScheduleSurgeryWithAllCondition(wait, driver, builder).verifyScheduleSurgeryWithAllCondition(fName,
				lName, favCategories, scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery, yagLaser,
				visibleLightLaser, locationOfSurgery, when, anesthesia, surgeon, assistantSurgeon, surgeryDate,
				Boolean.parseBoolean(preliminaryPlanningOfSurgeryComplete), Boolean.parseBoolean(patientNotify),
				Boolean.parseBoolean(preOpComplete), Boolean.parseBoolean(consentForm),
				Boolean.parseBoolean(iOLSelection), Boolean.parseBoolean(lRISelection),
				Boolean.parseBoolean(patientInstructions), Boolean.parseBoolean(daySurgeryOrders),
				Boolean.parseBoolean(prescriptionsGiven), Boolean.parseBoolean(sampleMedsGiven),
				Boolean.parseBoolean(preopOrders), drug, injection, location, needle, shutRef, iStentRef, axilAcd,
				impression, axisPlacement, methodK1, radiusk1, axisk1, methodK2, radiusk2, axisk2,
				IOLCalCulationFormula, PlannedIOL);
	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
