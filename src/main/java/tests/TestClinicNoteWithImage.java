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
import pages.PageClinicNoteWithImage;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestClinicNoteWithImage {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	// This cases generate the report of OpthamoscopyReports
	@Parameters({ "Enviorment", "FirstName", "LastName", "OpthamoscopyReports", "Category", "SubCategory1",
			"SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType",
			"NoCharges" })
	@Test(description = "This cases generate the report of OpthamoscopyReports", priority = 1, enabled = true, dataProvider = "ClinicNoteWithImageDetails", dataProviderClass = TestDataProviders.class)
	public void checkClinicNoteWithImage(String enviorment, String fName, String lName, String opthamosCopyReports,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, String significantProblem, String visitType, String noCharges) throws Exception {

		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		new PageClinicNoteWithImage(driver, wait, builder).verifyClinicNoteWithImage(fName, lName,opthamosCopyReports,
				category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges));

	}

	// close the driver
	// @AfterTest
	// public void logOut() {
	// driver.close();
	// }
}
