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
import pages.PgAutoCreatePatient;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAutoCreatepatient {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;

	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// logOn to certification Site
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

	// This function is use for insert Patient
	@Parameters({ "Enviorment", "PMSID", "MRN", "FirstName", "LastName", "Date", "SSN", "SexcualOrientation",
			"GenderIdentity", "Gender", "Address1", "Address2", "City", "State", "ZipCode", "HomePhone", "WorkPhone",
			"CellPhone", "Ethnicity", "Race", "Detailed race", "Email Address", "ContactMethod" })
	@Test(description = "This test  add new Ptient patient", priority = 2, enabled = true, dataProvider = "createpaterntDetails", dataProviderClass = TestDataProviders.class)
	public void checkPatientInsert(String enviorment, String PMSID, String MRN, String firstName, String lastName,
			String Date, String ssn, String SexcualOrientation, String GenderIdentity, String gender, String Address1,
			String Address2, String City, String State, String ZipCode, String HomePhone, String WorkPhone,
			String cellPhone, String Ethnicity, String Race, String Detailedrace, String EmailAddress,
			String ContactMethod) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		PgAutoCreatePatient erpFileSharing = new PgAutoCreatePatient(driver, wait, builder);
		Thread.sleep(5000);
		for (int i = 0; i <= 2; i++) {
		erpFileSharing.insertPatientDetails(PMSID, MRN, firstName, lastName, Date, ssn, SexcualOrientation,
				GenderIdentity, gender, Address1, Address2, City, State, ZipCode, HomePhone, WorkPhone, cellPhone,
				Ethnicity, Race, Detailedrace, EmailAddress, ContactMethod);

 }
		Thread.sleep(2000);
		ScreenShot shot = new ScreenShot();
		ScreenShot.screen(driver);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}

}
