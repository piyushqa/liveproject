
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
import pages.PageGeneratingAndPrintingOfRefferalReplyDoc;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestGeneratingAndPrintingOfRefferalReplyDoc {
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

	// In this test we upload the refferal report,rename,associates and then view
	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges",
			"AssociatesEncounter", "FileName", "RenameFile" })
	@Test(description = "In this test we upload the refferal report,rename,associates and then view ", priority = 1, enabled = true, dataProvider = "GeneratingAndPrintingRefferalDetails", dataProviderClass = TestDataProviders.class)
	public void checkGeneratingAndPrintingOfRefferalReplyDoc(String enviorment, String fName, String lName,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, String significantProblem, String documents, String visitType, String noCharges,
			String associateEncounter, String fileName, String reNameFile) throws Exception {

		// call the testLogin method for login in Application
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// call the patient search method for searching existing patient
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// call verifyGeneratingAndPrintingOfRefferalReplyDoc methods
		PageGeneratingAndPrintingOfRefferalReplyDoc refferalReplyDoc = new PageGeneratingAndPrintingOfRefferalReplyDoc(
				driver, wait, builder);
		refferalReplyDoc.verifyGeneratingAndPrintingOfRefferalReplyDoc(fName, lName, category, subCategory1,
				subCategory2, eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem),
				documents, visitType, Boolean.parseBoolean(noCharges), associateEncounter, fileName, reNameFile);
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
