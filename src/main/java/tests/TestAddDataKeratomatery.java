package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageAddDataKeratomatery;
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddDataKeratomatery {
	String exception = null;
	public WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
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
		builder=new Actions(driver);
		// ExtentReports report=new ExtentReports("./test-output/");

	}


	@Parameters({ "Enviorment","RightRadius", "RightAxis", "RightPower", "LeftRadius", "LeftAxis", "LeftPower", "Instrument" })
	@Test(description = "In this test case we add Keratomatery Data", priority = 2, enabled = true, dataProvider = "AddKeratomateryDetails", dataProviderClass = TestDataProviders.class)
	public void checkKeratomateryData(String enviorment,String fName, String lName, String provider, String rightRadius, String rightAxis,
			String rightPower, String leftRadius, String leftAxis, String leftPower, String instrument)
			throws Exception {
		LoginTest test=new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding=new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageAddDataKeratomatery addDataKeratomatery = new PageAddDataKeratomatery(wait, driver, builder);
		addDataKeratomatery.verfiyKeratomateryData(provider, rightRadius, rightAxis, rightPower, leftRadius, leftAxis,
				leftPower, instrument);

	}
}
