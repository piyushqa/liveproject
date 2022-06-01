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
import pages.PageMatchMedicationAndAllergieWithPatientEducation;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestMatchMedicationAndAllergieWithPatientEducation {
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

	@Parameters({ "Enviorment", "Mrn", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "Medicine", "Allergies", "Recation",
			"Severity", "Date" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "MedAndAllergieWithEducationDetails", dataProviderClass = TestDataProviders.class)
	public void checkMatchMedicationAndAllergieWithPatientEducation(String Enviorment, String Mrn, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String medicene, String allergies,
			String recation, String severity, String Date) throws Exception {

		// In this test cases login to application
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// search the patient
		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient("", "", Mrn, editPatient);

		new PageMatchMedicationAndAllergieWithPatientEducation(driver, wait, builder)
				.verifyMatchMedicationAndAllergieWithPatientEducation(category, subCategory1, subCategory2, eye,
						galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
						Boolean.parseBoolean(noCharges), medicene, allergies, recation, severity, Date);

	}
	
	@AfterTest
	public void logOut() {
		driver.close();
		
	}
}
