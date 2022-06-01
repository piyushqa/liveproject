package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgMedication;
import pages.PgMedicationOcular;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestMedication {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	// @Parameters({ "baseURL", "username", "password" })
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true, dataProvider = "LoginCredentials", dataProviderClass =
	// TestDataProviders.class)
	// public void testLogin(String baseURL, String usrnm, String pwd) throws
	// Exception {
	// boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
	// Reporter.log(ProjectSettings.baseURL + " opened successfully.");
	// PageLogIn pgLogin = new PageLogIn(driver);
	// try {
	// if (pgOpenStatus) {
	// lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
	// Reporter.log("Logged Successfully!");
	// }
	// } catch (Exception ex) {
	// Reporter.log(ex.toString());
	// }
	// }

	// log on to pgMedication
	@Parameters({ "FirstName", "LastName", "Provider", "Eye History", "MedicationName", "Month", "date", "Year",
			"Sysmeticmedication" })
	@Test(description = "This test add the medicine and match", priority = 2, enabled = true, dataProvider = "medicationDetails", dataProviderClass = TestDataProviders.class)
	public void checkMedicineDate(String fName, String lName, String provider, String eyeHistory, String medName,
			String month, String date, String year, String sysmeticmedication) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(4000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		Thread.sleep(2000);
		PgMedication med = new PgMedication(driver, wait, builder);
		med.verifyMedication(provider, eyeHistory, medName);
		med.checkStopDate(month, date, year, sysmeticmedication);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// // close the driver
	// @AfterTest
	// public void logOut() {
	// driver.close();
	// }

}
