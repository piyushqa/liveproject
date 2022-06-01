//addProviderTest.java
package tests;

import java.util.concurrent.TimeUnit;

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
import pages.PgAddExternalProvider;
import pages.PgLanding;
import pages.PgLogin;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AddProviderTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	// PgPatientSearch lclPgPatientSearch;
	// PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions action;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		action = new Actions(driver);
	}

	// login the URL
	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
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

	@Parameters({ "ProviderType", "SelectDegree", "FirstName", "MiddleName", "LastName", "InitialsCode", "NPI",
			"PMSystemRefCode", "AddressLine1", "City", "State", "ZIPCode", "OfficePhone", "Email", "DoctorNumber",
			"Pratice", "DirectAddress" })
	@Test(priority = 3, dataProvider = "providerDetails", dataProviderClass = TestDataProviders.class)
	public void addExternalProviderTest(String provider, String degree, String fName, String mName, String lName,
			String initialsCode, String npi, String refcode, String addressLine1, String city, String state,
			String zipcode, String officePhone, String email, String doctorNo, String pratice, String directAddress) {
		PgAddExternalProvider externalProvider = new PgAddExternalProvider(driver, wait, action);

		externalProvider.addExternalProvider(provider, degree, fName, mName, lName, initialsCode, npi, refcode,
				addressLine1, city, state, zipcode, officePhone, email, doctorNo, pratice, directAddress);
	}

	// close driver
	@AfterTest
	void closeDriver() {
		driver.quit();
	}

}
