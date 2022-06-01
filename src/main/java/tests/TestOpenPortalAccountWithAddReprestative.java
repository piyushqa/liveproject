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
import pages.PageOpenPortalAccountWithAddReprestative;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestOpenPortalAccountWithAddReprestative {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;
	SetUp lsetUp = new SetUp();
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	// In this test we add new patient and start new encounter and close encounter
	@Parameters({ "Enviorment", "PMSID", "MRN", "FirstName", "LastName", "Date", "SSN", "SexcualOrientation",
			"GenderIdentity", "Gender", "Address1", "Address2", "City", "State", "ZipCode", "HomePhone", "WorkPhone",
			"CellPhone", "Ethnicity", "Race", "Detailed race", "Email Address", "ContactMethod", "CalenderDate",
			"ZIPCODE", "NEWUSERNAME", "NewPswd", "ConfirmNewPswd", "AddRepName", "PhoneNumber",
			"RelatioshipToPatient" })
	@Test(description = "In this test cases first we create portal account then logOff after that create add representative and then reset password", priority = 1, enabled = true, dataProvider = "CreatePatientWithPortalAccountDetails", dataProviderClass = TestDataProviders.class)
	public void checkOpenPortalAccountWithAddReprestative(String enviorment, String PMSID, String MRN, String firstName,
			String lastName, String Date, String ssn, String SexcualOrientation, String GenderIdentity, String gender,
			String Address1, String Address2, String City, String State, String ZipCode, String HomePhone,
			String WorkPhone, String cellPhone, String Ethnicity, String Race, String Detailedrace, String EmailAddress,
			String ContactMethod, String calenderDate, String Zipcode, String newUserName, String newPswd,
			String ConfirmNewPswd, String addRepName, String phoneNumber, String relationShipToPatient)
			throws Exception {

		//System.out.println(calenderDate);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		new PageOpenPortalAccountWithAddReprestative(driver, wait, builder).verifyOpenPortalAccountWithAddReprestative(
				enviorment, PMSID, MRN, firstName, lastName, Date, ssn, SexcualOrientation, GenderIdentity, gender,
				Address1, Address2, City, State, ZipCode, HomePhone, WorkPhone, cellPhone, Ethnicity, Race,
				Detailedrace, EmailAddress, ContactMethod, Zipcode, newUserName, newPswd, ConfirmNewPswd, calenderDate,
				addRepName, phoneNumber, relationShipToPatient);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
