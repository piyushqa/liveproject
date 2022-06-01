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
import pages.PageCheckSettingSurgery;
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestCheckSettingsSurgery {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
Actions builder;

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

	// This test cases Check the setting of surgery
	@Parameters({ "Url", "IntegritySetting", "BaseUrl", "FirstName", "SecondName" })
	@Test(description = "This test cases Check the setting of surgery", priority = 2, enabled = true, dataProvider = "SeetingSurgeryDetails", dataProviderClass = TestDataProviders.class)
	public void verifySettingSurgery(String Url, String integritySetting, String baseUrl, String fName, String lName,
			String favCategories, String scheduleSurgery, String whichEye, String associateProWithProblem,
			String categoryOfSurgery, String procedureTime, String comanaging, String stagedProcedure,
			String relatedSurgeryBySameSurgeon, String unrelatedtSurgeryBySameSurgeon,
			String repeatSurgeryBySameSurgeon, String repeatSurgeryByDiffSurgeon, String locationOsSurgery, String when,
			String anesthesia, String surgeon, String assistantSurgeon, String preliminaryPlanningOfSurgeryComplete,
			String surgeryDate, String surgeryTime, String selectLabTest, String comment,
			String associateLabWithProblem, String designateTime, String patientNotify, String comment1,
			String consentForm, String iOLSelection, String lRISelection, String patientInstructions,
			String daySurgeryOrders, String prescriptionsGiven, String sampleMedsGiven, String preopOrders,
			String opNoteText, String opNoteLiberary, String ContractSurgery, String preOpComplete, String dataListItem)
			throws Exception {

		PageCheckSettingSurgery settingSurgery = new PageCheckSettingSurgery(driver, wait,builder);
		settingSurgery.checkSettingsurgery(Url, integritySetting, baseUrl, fName, lName, favCategories, scheduleSurgery,
				whichEye, associateProWithProblem, categoryOfSurgery, procedureTime, Boolean.parseBoolean(comanaging),
				Boolean.parseBoolean(stagedProcedure), Boolean.parseBoolean(relatedSurgeryBySameSurgeon),
				Boolean.parseBoolean(unrelatedtSurgeryBySameSurgeon), Boolean.parseBoolean(repeatSurgeryBySameSurgeon),
				Boolean.parseBoolean(repeatSurgeryByDiffSurgeon), locationOsSurgery, when, anesthesia, surgeon,
				assistantSurgeon, Boolean.parseBoolean(preliminaryPlanningOfSurgeryComplete), surgeryDate, surgeryTime,
				selectLabTest, comment, associateLabWithProblem, designateTime, Boolean.parseBoolean(patientNotify),
				comment1, Boolean.parseBoolean(consentForm), Boolean.parseBoolean(iOLSelection),
				Boolean.parseBoolean(lRISelection), Boolean.parseBoolean(patientInstructions),
				Boolean.parseBoolean(daySurgeryOrders), Boolean.parseBoolean(prescriptionsGiven),
				Boolean.parseBoolean(sampleMedsGiven), Boolean.parseBoolean(preopOrders), opNoteText, opNoteLiberary,
				ContractSurgery, Boolean.parseBoolean(preOpComplete), dataListItem);

	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
