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
import pages.PageRadiologyReport;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestRadiologyReport {
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

	// In this test cases we add radiology report and download from document center
	@Parameters({ "Enviorment","FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "RadioLogyTest", "Comments", "AssociatedWithProblem",
			"DesignateTime", "Date", "Clinic Note data", "SavedDocuments", "DownloadPath", "FileName", "VisitType",
			"NoCharges" })
	@Test(description = "In this test cases we add radiology report and download from document center", priority = 1, enabled = true, dataProvider = "RadioLogyReportDetails", dataProviderClass = TestDataProviders.class)
	public void checkRadiologyReport(String enviorment,String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String radioLogyTest, String comments, String associatesLabWithProblem,
			String designateTime, String date, String clinicNoteData, String saveDocuments, String downloadPah,
			String fileName, String visitType, String noCharges) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageRadiologyReport radiologyReport = new PageRadiologyReport(driver, wait, builder);
		radiologyReport.verifyRadiologyReport(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem), radioLogyTest, comments,
				associatesLabWithProblem, designateTime, date, clinicNoteData, saveDocuments, downloadPah, fileName,
				visitType, Boolean.parseBoolean(noCharges));
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
