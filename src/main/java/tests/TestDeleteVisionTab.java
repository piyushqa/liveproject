package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageDeleteVisionTab;
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestDeleteVisionTab {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extents;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;

	@BeforeTest
	// @Test(groups = { "logInAlways" })
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// logOn to certification Site
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

	@Parameters({ "FirstName", "LastName", "Provider", "History", "Category", "subCategory", "subCategory1", "Eye",
			"Glaucoma Severity", "Glaucoma Stability", "Vision", "DominantEye", "Distance", "Near", "OdDistance",
			"OdIntermidiate", "OdNear", "OsDistance", "OsIntermidiate", "OsNear", "BinocularDistance",
			"BinocularIntermidiate", "BinocularNear", "PinholeDistance", "PinholeIntermidiate", "PinholeNear" })
	@Test(description = "This test check UncorretedVa if add then delte otherwise first Add and then delete", priority = 2, enabled = true, dependsOnMethods = "testLogin", dataProvider = "DeleteUncorretedVADetails", dataProviderClass = TestDataProviders.class)
	public void checkDeleteUncorrectedVa(String fName, String lName, String provider, String history, String category,
			String subCategory, String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability,
			String vision, String dominantEye, String distance, String near, String odDistance, String odIntermidiate,
			String odNear, String osDistance, String osIntermidiate, String osNear, String binocularDistance,
			String binocularIntermidiate, String binocularNear, String pinholeDistance, String pinholeIntermidiate,
			String pinholeNear) throws Exception {
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageDeleteVisionTab delVision = new PageDeleteVisionTab(driver, wait, builder);
		delVision.vrifyUncorrectedVa(provider, history, category, subCategory, subCategory1, eye, glaucomaSeverity,
				glaucomaStability, vision, dominantEye, distance, near, odDistance, odIntermidiate, odNear, osDistance,
				osIntermidiate, osNear, binocularDistance, binocularIntermidiate, binocularNear, pinholeDistance,
				pinholeIntermidiate, pinholeNear);

	}
}
