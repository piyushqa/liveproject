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
import pages.PgAuthroziedRepresentative;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AuthroziedRepresnetativeTest {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	private WebDriverWait wait;
	private Actions action;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
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

	@Parameters({ "Name", "PhoneNo", "Email", "RelationshipToThePatient", "Firstname", "Lastname" })
	@Test(priority = 2, enabled = true, dataProvider = "authroziedRepresentativeDetails", dataProviderClass = TestDataProviders.class)
	public void editAuthroziedRepresentative(String name, String phoneNumber, String email,
			String relationshipToThePatient, String fName, String lName) throws Exception {

		PgAuthroziedRepresentative p2 = new PgAuthroziedRepresentative(driver, wait, action);

		p2.addAuthroziedRepresentative(name, phoneNumber, email, relationshipToThePatient, fName, lName);


	}

}
