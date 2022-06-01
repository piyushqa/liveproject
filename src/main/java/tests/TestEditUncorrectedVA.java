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
import pages.PageEditUncorrectedVA;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestEditUncorrectedVA {

	private WebDriver driver;
	private Actions builder;
	private WebDriverWait wait;
	SetUp lclSetup = new SetUp();
	PgPatientSearch lclPgPatientSrch;
	PgLanding lclPgLanding;
	ScreenShot shot;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lclSetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "OdDistance", "OdIntermediate", "OdNear",
			"OsDistance", "OsIntermediate", "OsNear", "BinDistance", "BinIntermediate", "BinNear", "PinOdDistance",
			"PinOdIntermediate", "PinOdNear", "PinOsDistance", "PinOsIntermediate", "PinOsNear", "EditOdDistance",
			"EditOdIntermediate", "EditOdNear", "EditOsDistance", "EditOsIntermediate", "EditOsNear" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "EditUncorrectedVADetails", dataProviderClass = TestDataProviders.class)
	public void checkEditUncorrectedVA(String enviorment, String fName, String lName, String provider,
			String OdDistance, String OdIntermediate, String OdNear, String OsDistance, String OsIntermediate,
			String OsNear, String BinDistance, String BinIntermediate, String BinNear, String PinOdDistance,
			String PinOdIntermediate, String PinOdNear, String PinOsDistance, String PinOsIntermediate,
			String PinOsNear, String editOdDistance, String editOdIntermediate, String editOdNear,
			String editOsDistance, String editOsIntermediate, String editOsNear) throws Exception {

		LoginTest tests = new LoginTest(driver);
		tests.testLogin();

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSrch = lclPgLanding.patientSearch();
		lclPgPatientSrch.searchPatient(fName, lName, "", editPatient);

		new PageEditUncorrectedVA(driver, wait, builder).checkEditUncorrectedVA(provider, OdDistance, OdIntermediate,
				OdNear, OsDistance, OsIntermediate, OsNear, BinDistance, BinIntermediate, BinNear, PinOdDistance,
				PinOdIntermediate, PinOdNear, PinOsDistance, PinOsIntermediate, PinOsNear, editOdDistance,
				editOdIntermediate, editOdNear, editOsDistance, editOsIntermediate, editOsNear);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
