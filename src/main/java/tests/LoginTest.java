package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.ProjectSettings;

import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;
import utilities.ScreenShot;

public class LoginTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/Users/win-0/Desktop");
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// ExtentReports report=new ExtentReports("./test-output/");

	}

public LoginTest(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//	@Parameters({ "baseURL", "username", "password" })
//	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	@Test(description = "This test logs into the application", priority = 1, enabled = true)
	//public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
		 public void testLogin() throws Exception {
		//boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		boolean pgOpenStatus = lsetup.getPage(driver, ProjectSettings.baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");

		PgLogin pgLogin = new PgLogin(driver);
		try {
			if (pgOpenStatus) {
				 //lclPgLanding = pgLogin.validLogin(usrnm, pwd);
				lclPgLanding = pgLogin.validLogin();

				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}

	}


	/*
	 * @Parameters({ "searchPatientFName", "searchPatientLName" })
	 *
	 * @Test(description = "Test to search for patient on Patient Search page",
	 * priority = 2, enabled = false) public void tstSearchPatient(String
	 * searchPatientFName, String searchPatientLName) throws Exception {
	 * lclPgPatientSearch = lclPgLanding.patientSearch();
	 * lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "",
	 * false); }
	 *
	 * @Parameters({ "MRN", "PMSId", "FirstName", "LastName", "DOB", "SSN",
	 * "Gender", "Address1", "Address2", "City", "State", "ZipCode", "HomePhone",
	 * "WorkPhone", "CellPhone", "Email", "Medicare", "Medicaid", "Unknown",
	 * "Language", "Ethnicity", "Race", "Deceased", "OnlineAccess", "ContactMethod"
	 * })
	 *
	 * @Test(description = "Test to search for patient on Patient Search page",
	 * priority = 3, enabled = true, dataProvider = "patientDetails",
	 * dataProviderClass = TestDataProviders.class) public void tstCreatePatient(
	 * String mrn, String pmsid, String firstName, String lastName, String dob,
	 * String ssn, String gender, String address1, String address2, String city,
	 * String state, String zipCode, String homePhone, String workPhone, String
	 * cellPhone, String email, String medicare, String medicaid, String unknown,
	 * String language, String ethnicity, String deceased, String race, String
	 * onlineAccess, String contactMethod ) throws Exception {
	 *
	 * lclpgCreatePatient = lclPgLanding.createPatient(); if
	 * (lclpgCreatePatient.createPatient( mrn, pmsid, firstName, lastName, dob, ssn,
	 * gender, address1, address2, city, state, zipCode, homePhone, workPhone,
	 * cellPhone, email, Boolean.parseBoolean(medicare),
	 * Boolean.parseBoolean(medicaid), Boolean.parseBoolean(unknown), language,
	 * ethnicity, Boolean.parseBoolean(deceased), race,
	 * Boolean.parseBoolean(onlineAccess), contactMethod )) {
	 * Reporter.log("Patient Saved successfully!"); } else {
	 * Reporter.log("Unable to Save the Patient"); } }
	 *
	 * @Parameters({ "pMRN", "pPMSId", "pFirstName", "pLastName", "pDob", "SSN",
	 * "pGender", "Address1", "Address2", "state", "pZipCode", "phPhone", "pwPhone",
	 * "pcPhone", "medicare", "medicaid", "unknown", "pPrefLang", "pEthnicity",
	 * "pRace", "pEmail", "pPrefContactMethod" })
	 *
	 * @Test(description = "Test to search for patient on Patient Search page",
	 * priority = 4, enabled = false) public void tstModifyPatient(String MRN,
	 * String PMSId, String firstName, String lastName, String dob, String SSN,
	 * String gender, String Address1, String Address2, String state, String
	 * ZipCode, String hPhone, String wPhone, String cPhone, boolean medicare,
	 * boolean medicaid, boolean unknown, String prefLang, String Ethnicity, String
	 * race, String patientEmail, String prefContactMethod) throws Exception {
	 * lclPgPatientSearch = lclPgLanding.patientSearch();
	 * lclPgPatientSearch.searchPatient("", "", MRN, true); lclpgCreatePatient =
	 * lclPgLanding.modifyPatient(); lclpgCreatePatient.modifyPatient(MRN, PMSId,
	 * firstName, lastName, dob, SSN, gender, Address1, Address2, state, ZipCode,
	 * hPhone, wPhone, cPhone, medicare, medicaid, unknown, prefLang, Ethnicity,
	 * race, patientEmail, prefContactMethod); }
	 */

}