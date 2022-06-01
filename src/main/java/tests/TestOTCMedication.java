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
import pages.PageOTCMedication;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestOTCMedication {
	private WebDriver driver;
	private WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;
	SetUp lclSt = new SetUp();
	ExtentReports reports;
	ExtentTest test;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lclSt.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);

	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges",
			"OTCMedicationLiberary", "ArtificialTears" })
	@Test(description = "In this test cases we are perform OTC Medication operation", priority = 1, enabled = true, dataProvider = "OTCMediactionTestDetails", dataProviderClass = TestDataProviders.class)
	public void checkOTCMedication(String enviorment, String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String otcMedicationLiberary,
			String artificialsTears) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageOTCMedication(driver, wait, builder).verifyOTCMedication(category, subCategory1, subCategory2, eye,
				galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
				Boolean.parseBoolean(noCharges), otcMedicationLiberary, artificialsTears);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
