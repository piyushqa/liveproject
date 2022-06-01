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
import pages.PgCreatePatient;
import pages.PgDrFirst;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgMedicationOcular;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestDrFirst {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions action;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Parameters({ "baseURL", "username", "password" })
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true, dataProvider = "LoginCredentials", dataProviderClass =
	// TestDataProviders.class)
	// public void testLogin(String baseURL, String usrnm, String pwd) throws
	// Exception {
	// boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
	// Reporter.log(ProjectSettings.baseURL + " opened successfully.");
	// PgLogin pgLogin = new PgLogin(driver);
	// try {
	// if (pgOpenStatus) {
	// lclPgLanding = pgLogin.validLogin(usrnm, pwd);
	// Reporter.log("Logged Successfully!");
	// }
	// } catch (Exception ex) {
	// Reporter.log(ex.toString());
	// }
	// }

	// log on to pgDrFirst
	@Parameters({ "Enviorment","FirstName", "LastName", "Provider", "Other History", "MedicationName", "Password", "Category",
			"SubCategory", "SubCategory1", "Eye", "GlaucomaSeverity", "GlaucomaStability", "Surgery",
			"FavouriteCategories", "ScheduleSurgery", "WhichEyeOrSide", "Problem", "Comanaging", "StagedProcedure",
			"LocationSurgery", "When,", "Anethesia", "Surgon", "AssitantSurgon", "CategoryOfSurgon", "Procedure",
			"PrimilareyPlanning" })
	@Test(description = "This test enter medicine ,Open surgery and close surgery", priority = 2, enabled = true, dataProvider = "DrFirstDetails", dataProviderClass = TestDataProviders.class)
	public void checkDrfirstProblem(String enviorment,String fName, String lName, String provider, String OtherHistory, String medName,
			String password, String category, String subCategory, String subCategory1, String eye,
			String glaucomaSeverity, String glaucomaStability, String surgery, String favouriteCategories,
			String scheduleSurgery, String whicheyeOrSide, String problem, String comanaging, String stagedprocedure,
			String locationSurgery, String when, String anethesia, String surgon, String assitantsurgon,
			String categoryOfsurgon, String procedure, String primilareyPlanning) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		Thread.sleep(2000);
		PgDrFirst drFrst = new PgDrFirst(driver, wait, action);
		drFrst.verifyDrFirst(provider, OtherHistory, medName, password, category, subCategory, subCategory1, eye,
				glaucomaSeverity, glaucomaStability, surgery, favouriteCategories, scheduleSurgery, whicheyeOrSide,
				problem, Boolean.parseBoolean(comanaging), Boolean.parseBoolean(stagedprocedure), locationSurgery, when,
				anethesia, surgon, assitantsurgon, categoryOfsurgon, procedure,
				Boolean.parseBoolean(primilareyPlanning));

		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// After Test

//	 @AfterTest
//	 public void logOut() {
//	 driver.close();
//	 }

}
