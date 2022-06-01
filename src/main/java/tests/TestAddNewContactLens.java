package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageAddNewContactLens;
import pages.PgCreatePatient;
import pages.PgEncounter;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddNewContactLens {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions action;
	public ScreenShot shot;
	private Actions builder;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({"Enviorments","FirstName", "LastName", "Provider", "LenseMake", "QuickNotes", "Movement", "RotationRight",
			"Surface", "Decentration", "RotationLift", "Monovision", "Prespriction", "Sphere", "Cylinder", "Axis",
			"Add", "Distance", "Intermediate", "Near" })
	@Test(description = "In this test cases add new contact lense", priority = 1, enabled = true, dataProvider = "ContactLensDetails", dataProviderClass = TestDataProviders.class)
	public void checkAddNewContactLense(String enviorments,String fName, String lName, String provider, String lensMake, String quickNotes,
			String movement, String rotationRight, String surface, String decentration, String rotationLeft,
			String monovision, String prespriction, String sphere, String cylinder, String axis, String add,
			String distance, String intermediate, String near) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		
		

		PageAddNewContactLens newCL = new PageAddNewContactLens(wait, driver, builder);
		newCL.verifyAddNewContactLense(provider, lensMake, quickNotes, movement, rotationRight, surface, decentration,
				rotationLeft, monovision, prespriction, sphere, cylinder, axis, add, distance, intermediate, near);

	}
}
