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
import pages.PageAddCustomCL;
import pages.PageVerifyAssociatesProviders;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddCustomCL {

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

	@Parameters({ "Enviorments", "FirstName", "LastName", "Provider", "SelectRightEyeSphere", "SelectLeftEyeSphere",
			"Name", "Cylinder", "Type", "SelectValue", "BC1", "BC2", "Diameter", "Color" })

	@Test(description = "verify personal touch", priority = 1, enabled = true, dataProvider = "AddCustomCLDetails", dataProviderClass = TestDataProviders.class)
	public void checkPersonalTouch(String enviorment, String fName, String lName, String provider,
			String selectRightSphere, String selectLeftSphere, String name, String cylinder, String type,
			String selectValue, String BC1, String BC2, String diam, String color) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// search the patient
		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageAddCustomCL(driver, wait, builder).verifyAddCustomCL(provider, selectRightSphere, selectLeftSphere,
				name, cylinder, type, selectValue, BC1, BC2, diam, color);

	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}

}
