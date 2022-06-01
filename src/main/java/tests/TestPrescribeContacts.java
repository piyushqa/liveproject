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
import pages.PagePrescribeContacts;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestPrescribeContacts {

	Actions builder;
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "LenseMake", "OD", "OdSphere", "OdCyliender",
			"OdAxis", "OdAdd", "OS", "OsSphere", "OsCyliender", "OsAxis", "OsAdd", "Prism", "Prism1", "Prism2",
			"Prism3", "OdDistance", "OsDistance", "OdIntermediate", "OsIntermediate", "OdNear", "OsNear", "OdComment",
			"OsComment", "LensPrescription", "LensStatus" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "PrescibeContactDeatils", dataProviderClass = TestDataProviders.class)
	public void checkPrescribeContacts(String enviorment, String fName, String lName, String provider, String lensMake,
			String od, String odSphere, String odCyliender, String odAxis, String odAdd, String os, String osSphere,
			String osCyliender, String osAxis, String osAdd, String prism, String prism1, String prism2, String prism3,
			String odDistance, String osDistance, String odIntermediate, String osIntermediate, String odNear,
			String osNear, String OdComment, String osComment, String lensPrescription, String lenStatus)
			throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		new PagePrescribeContacts(driver, wait, builder).verifyPrescribeContacts(provider, lensMake, od, odSphere,
				odCyliender, odAxis, odAdd, os, osSphere, osCyliender, osAxis, osAdd, prism, prism1, prism2, prism3,
				odDistance, osDistance, odIntermediate, osIntermediate, odNear, osNear, OdComment, osComment,
				lensPrescription, lenStatus);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
