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
import pages.PageAddAllergies;

import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddAllergies {
	String exception = null;
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	SetUp lsetUp = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgpatientSrch;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "Allergies", "Recation", "Severity", "Date",
			"Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability",
			"significantProblem", "VisitType", "NoCharges" })
	@Test(description = "In this test case we update the allergy on DR First and match date on EMR", priority = 1, enabled = true, dataProvider = "AddAllergiesDetails", dataProviderClass = TestDataProviders.class)
	public void checkAddAllergies(String enviorment, String fName, String lName, String provider, String allergies,
			String recation, String severity, String Date, String category, String subCategory1, String subCategory2,
			String eye, String galuocmaSeverity, String galuocmaStability, String significantProblem, String visitType,
			String noCharges) throws Exception {
		// Login to EMR Application
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// search the patient
		Thread.sleep(4000);
		boolean editPatient = false;
		//lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient(fName, lName, "", editPatient);

		// call add allergy method
		Thread.sleep(2000);
		PageAddAllergies addAllergies = new PageAddAllergies(driver, wait, builder);
		addAllergies.verifyAddAllerigies(provider, allergies, recation, severity, Date, category, subCategory1,
				subCategory2, eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem),
				visitType, Boolean.parseBoolean(noCharges));

	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
