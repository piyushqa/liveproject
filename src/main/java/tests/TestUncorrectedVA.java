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
import pages.PageUncorrectedVA;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestUncorrectedVA {

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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "OdDistance", "OdIntermediate", "OdNear",
			"OsDistance", "OsIntermediate", "OsNear", "BinDistance", "BinIntermediate", "BinNear", "PinOdDistance",
			"PinOdIntermediate", "PinOdNear", "PinOsDistance", "PinOsIntermediate", "PinOsNear", "VisitType",
			"NoCharges" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "AddUncorrectedVADetails", dataProviderClass = TestDataProviders.class)
	public void checkUCVAData(String enviorment, String fName, String lName, String provider, String OdDistance,
			String OdIntermediate, String OdNear, String OsDistance, String OsIntermediate, String OsNear,
			String BinDistance, String BinIntermediate, String BinNear, String PinOdDistance, String PinOdIntermediate,
			String PinOdNear, String PinOsDistance, String PinOsIntermediate, String PinOsNear, String visitType,
			String noCharges) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		Boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageUncorrectedVA(driver, wait, builder).verifyUCVAData(provider, OdDistance, OdIntermediate, OdNear,
				OsDistance, OsIntermediate, OsNear, BinDistance, BinIntermediate, BinNear, PinOdDistance,
				PinOdIntermediate, PinOdNear, PinOsDistance, PinOsIntermediate, PinOsNear, visitType,
				Boolean.parseBoolean(noCharges));
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
