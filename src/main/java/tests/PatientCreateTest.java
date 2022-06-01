package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class PatientCreateTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Parameters({ "username", "password" })
//	@Test(description = "This test logs into the application", priority = 1, enabled = true)
//	public void tstLogin(String usrnm, String pwd) throws Exception {
//		boolean pgOpenStatus = lsetup.getPage(driver, ProjectSettings.baseURL);
//		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
//		PgLogin pgLogin = new PgLogin(driver);
//		try {
//			if (pgOpenStatus) {
//				lclPgLanding = pgLogin.validLogin(usrnm, pwd);
//				Reporter.log("Logged Successfully!");
//			}
//		} catch (Exception ex) {
//			Reporter.log(ex.toString());
//		}
//	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	public void tstLogin(String baseURL, String usrnm, String pwd) throws Exception {
		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
		PageLogIn pgLogin = new PageLogIn(driver);
		try {
			if (pgOpenStatus) {
				lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}
	}

	@Parameters({
		  "MRN",
		  "PMSId",
		  "FirstName",
		  "LastName",
		  "DOB",
		  "SSN",
		  "Gender",
		  "Address1",
		  "Address2",
		  "City",
		  "State",
		  "ZipCode",
		  "HomePhone",
		  "WorkPhone",
		  "CellPhone",
		  "Email",
		  "Medicare",
		  "Medicaid",
		  "Unknown",
		  "Language",
		  "Ethnicity",
		  "Race",
		  "Deceased",
		  "OnlineAccess",
		  "ContactMethod"
		})
	@Test(description = "Test to search for patient on Patient Search page", priority = 3, enabled = true, dataProvider = "patientDetails", dataProviderClass = TestDataProviders.class)
	public void tstCreatePatient(
			String mrn,
			  String pmsid,
			  String firstName,
			  String lastName,
			  String dob,
			  String ssn,
			  String gender,
			  String address1,
			  String address2,
			  String city,
			  String state,
			  String zipCode,
			  String homePhone,
			  String workPhone,
			  String cellPhone,
			  String email,
			  String medicare,
			  String medicaid,
			  String unknown,
			  String language,
			  String ethnicity,
			  String deceased,
			  String race,
			  String onlineAccess,
			  String contactMethod
			) throws Exception {

		lclpgCreatePatient = lclPgLanding.createPatient();
		if (lclpgCreatePatient.createPatient(
			mrn,
			  pmsid,
			  firstName,
			  lastName,
			  dob,
			  ssn,
			  gender,
			  address1,
			  address2,
			  city,
			  state,
			  zipCode,
			  homePhone,
			  workPhone,
			  cellPhone,
			  email,
			  Boolean.parseBoolean(medicare),
			  Boolean.parseBoolean(medicaid),
			  Boolean.parseBoolean(unknown),
			  language,
			  ethnicity,
			  Boolean.parseBoolean(deceased),
			  race,
			  Boolean.parseBoolean(onlineAccess),
			  contactMethod
			)
			) {
			Reporter.log("Patient Saved successfully!");
		} else {
			Reporter.log("Unable to Save the Patient");
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		/*
		 * extent.endTest(test); extent.flush(); extent.close();
		 */
		driver.close();
	}
}
