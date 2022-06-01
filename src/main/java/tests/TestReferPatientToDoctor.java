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
import pages.PageReferPatientToDoctor;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestReferPatientToDoctor {
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

	//In this test cases we refer patient to doctor and match actual and excepted data
	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "TimeFrame",
			"Transition", "ProviderName" })
	@Test(description = "In this test cases we refer patient to doctor and match actual and excepted data", priority = 1, enabled = true, dataProvider = "ReferPatientToDocterdetails", dataProviderClass = TestDataProviders.class)
	public void checkReferPatientToDoctor(String enviorment, String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String timeFrame, String transition,
			String providerName) throws Exception {

		//In this test cases login to application
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		//search the patient
		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		//invoke verify Refer Patient To Doctor from verify Refer Patient To Doctor class
		new PageReferPatientToDoctor(driver, wait, builder).verifyReferPatientToDoctor(category, subCategory1,
				subCategory2, eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem),
				visitType, Boolean.parseBoolean(noCharges), timeFrame, Boolean.parseBoolean(transition), providerName);

	}

	//close the browser
	@AfterTest
	public void logOut() {
		driver.close();
	}
}
