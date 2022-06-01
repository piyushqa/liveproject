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
import pages.PageOpenEncounterWithNewPatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestOpenEncounterWithNewPatient {

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

	// In this test we add new patient and start new encounter and close encounter
	@Parameters({ "Enviorment", "PMSID", "MRN", "FirstName", "LastName", "Date", "SSN", "SexcualOrientation",
			"GenderIdentity", "Gender", "Address1", "Address2", "City", "State", "ZipCode", "HomePhone", "WorkPhone",
			"CellPhone", "Ethnicity", "Race", "Detailed race", "Email Address", "ContactMethod", "Category",
			"SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem",
			"VisitType", "NoCharges" })
	@Test(description = "In this test we add new patient and start new encounter and close encounter", priority = 1, enabled = true, dataProvider = "CreatePatientWithNewEncounterDetails", dataProviderClass = TestDataProviders.class)
	public void checkOpenEncounterWithNewPatient(String enviorment, String PMSID, String MRN, String firstName,
			String lastName, String Date, String ssn, String SexcualOrientation, String GenderIdentity, String gender,
			String Address1, String Address2, String City, String State, String ZipCode, String HomePhone,
			String WorkPhone, String cellPhone, String Ethnicity, String Race, String Detailedrace, String EmailAddress,
			String ContactMethod, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, String significantProblem, String visitType,
			String noCharges) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// invoke method of PageOpenEncounterWithNewPatient class
		Thread.sleep(3000);
		new PageOpenEncounterWithNewPatient(driver, wait, builder).verifyOpenEncounterWithNewPatient(enviorment, PMSID,
				MRN, firstName, lastName, Date, ssn, SexcualOrientation, GenderIdentity, gender, Address1, Address2,
				City, State, ZipCode, HomePhone, WorkPhone, cellPhone, Ethnicity, Race, Detailedrace, EmailAddress,
				ContactMethod, category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges));

	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
