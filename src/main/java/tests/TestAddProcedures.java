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
import pages.PageAddProcedures;

import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddProcedures {
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
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	// In this test case add one procedure and match with clinic Note data
	@Parameters({"Enviorment","FirstName", "Lastname", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "ProcedureLiberay", "Botox", "AssociatedDiagnosis", "EyeOrSide",
			"YagLaser", "VisibleLightsLeaser", "VisitType", "Nocharges" })
	@Test(description = "In this test case add one procedure and match with clinic Note data", priority = 1, enabled = true, dataProvider = "AddProceduresDetails", dataProviderClass = TestDataProviders.class)
	public void checkAddProcedures(String enviorment,String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String procedureLiberay, String botox, String associatedDiagnosis,
			String eyeOrSide, String yagLaser, String visibleLightsLeaser, String visitType, String noCharges)
			throws Exception {
		// Login class
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// Search patient
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageAddProcedures procedures = new PageAddProcedures(driver, wait, builder);
		procedures.verifyAddProcedurs(category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), procedureLiberay, botox, associatedDiagnosis, eyeOrSide,
				yagLaser, visibleLightsLeaser, visitType, Boolean.parseBoolean(noCharges));
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}
