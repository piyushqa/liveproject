package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageOpthalmoscopyReports;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;
import utilities.ScreenShot;

public class TestOpthalmoscopyReports {
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
	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "OpthamoscopyReports", "SavedOcuments",
			"DownLoadPath", "FileName" })
	@Test(description = "This cases generate the report of OpthamoscopyReports", priority = 1, enabled = true, dataProvider = "OpthalmoscopyReportsDetails", dataProviderClass = TestDataProviders.class)
	public void checkOpthalmosCopyReports(String enviorment, String fName, String lName, String provider,
			String opthamosCopyReports, String savedDocuments, String downloadpath, String filename) throws Exception {

		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageOpthalmoscopyReports opthaReport = new PageOpthalmoscopyReports(driver, wait, builder);
		opthaReport.createOpthamoscopyReports(provider, opthamosCopyReports, savedDocuments, downloadpath, filename);
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	// close the driver
	@AfterTest
	public void logOut() {
		driver.close();
	}
}
