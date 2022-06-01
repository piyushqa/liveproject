package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PgCreatePatient;
import pages.PgEncounter;

import pages.PgErpLanding;

import pages.PgLanding;
import pages.PgLogin;

import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestEncounter {

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
		builder = new Actions(driver);
	}

	// Test function for Uncorrected VA

	@Parameters({ "FirstName", "LastName", "Provider", "History", "Category", "subCategory", "subCategory1", "Eye",
			"Glaucoma Severity", "Glaucoma Stability", "Vision", "DominantEye", "Distance", "Near", "OdDistance",
			"OdIntermidiate", "OdNear", "OsDistance", "OsIntermidiate", "OsNear", "BinocularDistance",
			"BinocularIntermidiate", "BinocularNear", "PinholeDistance", "PinholeIntermidiate", "PinholeNear" })

	@Test(description = "This test add Encounter and fill value in Uncorrected VA", priority = 2, enabled = true, dataProvider = "EncounterDetails", dataProviderClass = TestDataProviders.class)
	public void testUncorrectedVA(String fName, String lName, String provider, String history, String category,
			String subCategory, String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability,
			String vision, String dominantEye, String distance, String near, String odDistance, String odIntermidiate,
			String odNear, String osDistance, String osIntermidiate, String osNear, String binocularDistance,
			String binocularIntermidiate, String binocularNear, String pinholeDistance, String pinholeIntermidiate,
			String pinholeNear) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PgEncounter encounter = new PgEncounter(driver, wait, builder);
		encounter.addUncorrectedVA(provider, history, category, subCategory, subCategory1, eye, glaucomaSeverity,
				glaucomaStability, vision, dominantEye, distance, near, odDistance, odIntermidiate, odNear, osDistance,
				osIntermidiate, osNear, binocularDistance, binocularIntermidiate, binocularNear, pinholeDistance,
				pinholeIntermidiate, pinholeNear);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// Test function for Existing Glasses
	@Parameters({ "OD", "OdSphere", "OdCyliender", "OdAxis", "OdAdd", "OS", "OsSphere", "OsCyliender", "OsAxis",
			"OsAdd", "Prism", "Prism1", "Prism2", "Prism3", "OdDistance", "OsDistance", "OdIntermediate",
			"OsIntermediate", "OdNear", "OsNear", "OdComment", "OsComment" })
	@Test(description = "This test perform encounter on Existin glass", priority = 3, enabled = true, dependsOnMethods = "testUncorrectedVA", dataProvider = "ExistingGlassDetails", dataProviderClass = TestDataProviders.class)
	public void encounterOnExistingGlass(String od, String odSphere, String odCyliender, String odAxis, String odAdd,
			String os, String osSphere, String osCyliender, String osAxis, String osAdd, String prism, String prism1,
			String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment)
			throws InterruptedException, IOException {

		PgEncounter encounterOnGlass = new PgEncounter(driver, wait, builder);
		encounterOnGlass.addNewExistingglass(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender,
				osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate,
				odNear, osNear, OdComment, osComment);
		System.out.println(odSphere);
		System.out.println(odCyliender);
		System.out.println(odAxis);
		System.out.println(odAdd);
		System.out.println(osSphere);
		System.out.println(osCyliender);
		System.out.println(osAxis);
		System.out.println(osAdd);

		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// TestFunction For Refraction
	@Parameters({ "OD", "OdSphere", "OdCyliender", "OdAxis", "OdAdd", "OS", "OsSphere", "OsCyliender", "OsAxis",
			"OsAdd", "Prism", "Prism1", "Prism2", "Prism3", "OdDistance", "OsDistance", "OdIntermediate",
			"OsIntermediate", "OdNear", "OsNear", "OdComment", "OsComment" })

	@Test(description = "This test perform encounter on Refraction", priority = 4, enabled = true, dependsOnMethods = "encounterOnExistingGlass", dataProvider = "RefractionDetails", dataProviderClass = TestDataProviders.class)
	public void encounterOnRefraction(String od, String odSphere, String odCyliender, String odAxis, String odAdd,
			String os, String osSphere, String osCyliender, String osAxis, String osAdd, String prism, String prism1,
			String prism2, String prism3, String odDistance, String osDistance, String odIntermediate,
			String osIntermediate, String odNear, String osNear, String OdComment, String osComment)
			throws InterruptedException, IOException {
		PgEncounter encounterOnRefraction = new PgEncounter(driver, wait, builder);
		encounterOnRefraction.addNewRefraction(od, odSphere, odCyliender, odAxis, odAdd, os, osSphere, osCyliender,
				osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate, osIntermediate,
				odNear, osNear, OdComment, osComment);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// TestFunction for ContactLens
	@Parameters({ "LensMake" })
	@Test(description = "This test perform encounter on ContactLens", priority = 5, enabled = true, dependsOnMethods = "encounterOnRefraction", dataProvider = "ContactLensDetails", dataProviderClass = TestDataProviders.class)
	public void encounterOnContactLens(String lensMake) throws InterruptedException, IOException {
		Thread.sleep(2000);
		PgEncounter encounterOnContactLens = new PgEncounter(driver, wait, builder);
		encounterOnContactLens.addNewContacLens(lensMake);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// TestFunction for Keratometry
	@Parameters({ "RightRadius", "RightAxis", "RightPower", "LeftRadius", "LeftAxis", "LeftPower", "Instrument" })
	@Test(description = "This test perform encounter on Keratometry", priority = 6, enabled = true, dependsOnMethods = "encounterOnContactLens", dataProvider = "KeratometryDetails", dataProviderClass = TestDataProviders.class)
	public void encounterOnKeratometry(String rightRadius, String rightAxis, String rightPower, String leftRadius,
			String leftAxis, String leftPower, String instrument) throws InterruptedException, IOException {
		Thread.sleep(3000);
		PgEncounter encounterOnKeratometry = new PgEncounter(driver, wait, builder);
		encounterOnKeratometry.addNewKeratometry(rightRadius, rightAxis, rightPower, leftRadius, leftAxis, leftPower,
				instrument);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

}
