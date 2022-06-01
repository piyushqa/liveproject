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
import pages.PageVisionRefraction;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestVisionRefraction {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extents;
	public static ExtentTest
	test;
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
	// @Parameters({ "baseURL", "username", "password" })
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true, dataProvider = "LoginCredentials", dataProviderClass =
	// TestDataProviders.class)
	// public void testLogin(String baseURL, String usrnm, String pwd) throws
	// Exception {
	// boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
	// Reporter.log(ProjectSettings.baseURL + " opened successfully.");
	// PgLogin pgLogin = new PgLogin(driver);
	// try {
	// if (pgOpenStatus) {
	// lclPgLanding = pgLogin.validLogin(usrnm, pwd);
	// Reporter.log("Logged Successfully!");
	// }
	// } catch (Exception ex) {
	// Reporter.log(ex.toString());
	// }
	// }

	@Parameters({"Enviorment","FirstName", "LastName", "Provider", "OD", "OdSphere", "OdCyliender", "OdAxis", "OdAdd", "OS",
			"OsSphere", "OsCyliender", "OsAxis", "OsAdd", "Prism", "Prism1", "Prism2", "Prism3", "OdDistance",
			"OsDistance", "OdIntermediate", "OsIntermediate", "OdNear", "OsNear", "OdComment", "OsComment", "LenksMake",
			"GlassRx", "Usage", "Type", "LensMaterial", "lensTreatment", "CommentGlass" })
	@Test(description = "This test cases test the vision refrcation and match on Contact Lense", priority = 1, enabled = true, dataProvider = "VisionRefractionDetails", dataProviderClass = TestDataProviders.class)
	public void checkVisionControl(String enviorment,String fName, String lName, String provider, String od, String odSphere,
			String odCyliender, String odAxis, String odAdd, String os, String osSphere, String osCyliender,
			String osAxis, String osAdd, String prism, String prism1, String prism2, String prism3, String odDistance,
			String osDistance, String odIntermediate, String osIntermediate, String odNear, String osNear,
			String OdComment, String osComment, String lensMake, String glassRx, String usage, String type,
			String lensMaterial, String lensTreatment, String commentGlass) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(4000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageVisionRefraction visionRef = new PageVisionRefraction(driver, wait, builder);
		visionRef.matchVisionRefraction(provider, od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender,
				osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate,
				odNear, osNear, OdComment, osComment, lensMake, glassRx, Boolean.parseBoolean(usage),
				Boolean.parseBoolean(type), Boolean.parseBoolean(lensMaterial), Boolean.parseBoolean(lensTreatment),
				commentGlass);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
