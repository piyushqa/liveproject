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
import pages.PageASCIntegrationForPopUpWindow;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestASCIntegrationForPopUpWindow {

	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	Actions builder;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorments", "FirstName", "LastName", "Favorites Categories", "Schedule Surgery",
			"Which Eye or Side?", "Associate Procedure with a Problem", "Category of Surgery", "Comanaging",
			"Staged procedure", "Related surgery by same surgeon", "Unrelated surgery by same surgeon",
			"Repeat surgery by same surgeon", "Repeat surgery by different surgeon", "Location of Surgery", "When",
			"Anesthesia", "Surgeon", "Assistant Surgeon", "Preliminary planning of surgery complete", "SurgeryDate",
			"SurgeryTime", "Select Lab Tests", " Comments", " Associate Lab with a Problem", "Designate a Time",
			"Patient Notified", "Comments1", "Consent Form", "IOL Selection", "LRI Selection", "Patient Instructions",
			"Day Surgery Orders", "Prescriptions Given", "Sample Meds Given", "Pre-op Orders", "Pre-op Complete",
			"yagLaser", "VisibleLightLaser", "Drug", "Injection", "Location", "Needle", "shutRef", "iStentRef",
			"Axial-Acd", "Impresson", "AxisPlacement", "MethodK1", "RadiusK1", "Axisk1", "MethodK2", "RadiusK2",
			"AxisK2", "IOLCalCulationFormula", "PlannedIOL","Documents"})
	@Test(description = "In this secnario we check ASC integration", priority = 1, enabled = true, dataProvider = "ASCIntegrationPopUpWindowDetails", dataProviderClass = TestDataProviders.class)
	public void checkASCIntegrationForPopUpWindow(String enviorment, String fName, String lName, String favCategories,
			String scheduleSurgery, String whichEye, String associateProWithProblem, String categoryOfSurgery,
			String comanaging, String stagedProcedure, String relatedSurgeryBySameSurgeon,
			String unrelatedtSurgeryBySameSurgeon, String repeatSurgeryBySameSurgeon, String repeatSurgeryByDiffSurgeon,
			String locationOsSurgery, String when, String anesthesia, String surgeon, String assistantSurgeon,
			String preliminaryPlanningOfSurgeryComplete, String surgeryDate, String surgeryTime, String selectLabTest,
			String comment, String associateLabWithProblem, String designateTime, String patientNotify, String comment1,
			String consentForm, String iOLSelection, String lRISelection, String patientInstructions,
			String daySurgeryOrders, String prescriptionsGiven, String sampleMedsGiven, String preopOrders,
			String preOpComplete, String yagLaser, String visibleLightLaser, String drug, String injection,
			String location, String needle, String shutRef, String iStentRef, String axilAcd, String impression,
			String axisPlacement, String methodK1, String radiusk1, String axisk1, String methodK2, String radiusk2,
			String axisk2, String IOLCalCulationFormula, String PlannedIOL,String documents) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageASCIntegrationForPopUpWindow(wait, driver, builder).verifyASCIntegrationForPopUpWindow(fName, lName,
				favCategories, scheduleSurgery, whichEye, associateProWithProblem, categoryOfSurgery,
				Boolean.parseBoolean(comanaging), Boolean.parseBoolean(stagedProcedure),
				Boolean.parseBoolean(relatedSurgeryBySameSurgeon), Boolean.parseBoolean(unrelatedtSurgeryBySameSurgeon),
				Boolean.parseBoolean(repeatSurgeryBySameSurgeon), Boolean.parseBoolean(repeatSurgeryByDiffSurgeon),
				locationOsSurgery, when, anesthesia, surgeon, assistantSurgeon,
				Boolean.parseBoolean(preliminaryPlanningOfSurgeryComplete), surgeryDate, surgeryTime, selectLabTest,
				comment, associateLabWithProblem, designateTime, Boolean.parseBoolean(patientNotify), comment1,
				Boolean.parseBoolean(consentForm), Boolean.parseBoolean(iOLSelection),
				Boolean.parseBoolean(lRISelection), Boolean.parseBoolean(patientInstructions),
				Boolean.parseBoolean(daySurgeryOrders), Boolean.parseBoolean(prescriptionsGiven),
				Boolean.parseBoolean(sampleMedsGiven), Boolean.parseBoolean(preopOrders),
				Boolean.parseBoolean(preOpComplete), yagLaser, visibleLightLaser, drug, injection, location, needle,
				shutRef, iStentRef, axilAcd, impression, axisPlacement, methodK1, radiusk1, axisk1, methodK2, radiusk2,
				axisk2, IOLCalCulationFormula, PlannedIOL,documents);
	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
