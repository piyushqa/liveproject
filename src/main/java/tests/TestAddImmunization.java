package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import config.ExtentReporterNG;
import config.ProjectSettings;
import pages.PageAddImmunization;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ExtentTestManager;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddImmunization {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test1;
	public ScreenShot shot;
	ExtentTestManager manager;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);

	}

	// Fuction for Check Immunization
	@Parameters({"Enviorment","FirstName", "LastName", "ImmunizationTypes", "AmontUnits", "ImmunizationDate", "LotMfgNameMfgCode",
			"ImmunizationStatus" })
	@Test(description = "Add immunization data and download report", priority = 1, enabled = true, dataProvider = "ImmunizationDetails", dataProviderClass = TestDataProviders.class)
	public void checkImmunization(String enviorment,String fName, String lName, String immunizationsTypes, String AmontUnits,
			String immunizationdate, String lotMfgCodeAndName, String immunizationStatus) throws Exception {

//		manager = new ExtentTestManager(driver, manager);
//		ExtentTestManager.getTest().setDescription("Add immunization data and download report");
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageAddImmunization immunization = new PageAddImmunization(wait, driver, builder);
		immunization.verifyImmunization(immunizationsTypes, AmontUnits, immunizationdate, lotMfgCodeAndName,
				immunizationStatus);
		Thread.sleep(2000);
		ScreenShot shot = new ScreenShot();
		ScreenShot.screen(driver);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}