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
import pages.PageCloseEncounter;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestCloseEncounter {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "PlanLiberay", "SubPlanLiberay", "VisitType",
			"NoCharges" })
	@Test(description = "In this test case open the encounter and new plan/problem and then close the encounter", priority = 1, enabled = true, dataProvider = "CloseEncounterDetails", dataProviderClass = TestDataProviders.class)
	public void checkForCloseEncounter(String enviorment, String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String planLiberay, String SubPlanLiberay, String visitType, String noCharges)
			throws Exception {

		// For Login In Application
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// Serach For Existing Patient
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// Open the PageCloseEncounter
		PageCloseEncounter closeEncounter = new PageCloseEncounter(wait, driver, builder);
		closeEncounter.verifyCloseEncounter(fName, lName, category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem), planLiberay, SubPlanLiberay, visitType,
				Boolean.parseBoolean(noCharges));
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
