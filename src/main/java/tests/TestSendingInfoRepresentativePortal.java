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
import pages.PageSendingInfoRepresentativePortal;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSendingInfoRepresentativePortal {
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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Allergies", "Recation", "Severity", "Date", "Category",
			"SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem",
			"VisitType", "NoCharges", "File:ocation", "reNameFile" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "SendingInfoRepPortalDetails", dataProviderClass = TestDataProviders.class)
	public void checkSendingInfoRepresentativePortal(String enviorment, String fName, String lName, String allergies,
			String recation, String severity, String Date, String category, String subCategory1, String subCategory2,
			String eye, String galuocmaSeverity, String galuocmaStability, String significantProblem, String visitType,
			String noCharges, String fileLocation, String renameFileName) throws Exception {
		// Login to EMR Application
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// search the patient
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient(fName, lName, "", editPatient);

		PageSendingInfoRepresentativePortal infoRepPoratl = new PageSendingInfoRepresentativePortal(driver, wait,
				builder);
		infoRepPoratl.verifySendingInfoRepresentativePortal(allergies, recation, severity, Date, category, subCategory1,
				subCategory2, eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem),
				visitType, Boolean.parseBoolean(noCharges), fileLocation, renameFileName);
	}
}
