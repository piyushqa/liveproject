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
import pages.PageUpdateAllergies;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestUpdateAllergies {
	String exception = null;
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	SetUp lsetUp = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgpatientSrch;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "Recation", "Severity", "ModifyDate" })
	@Test(description = "In this test case we update the allergy on DR First and match date on EMR", priority = 1, enabled = true, dataProvider = "UpdateAllergiesDetails", dataProviderClass = TestDataProviders.class)
	public void checkUpdateAllergies(String enviorment, String fName, String lName, String provider, String recation,
			String severity, String modifyDate) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(4000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgpatientSrch = lclPgLanding.patientSearch();
		lclPgpatientSrch.searchPatient(fName, lName, "", editPatient);

		PageUpdateAllergies updateAllergies = new PageUpdateAllergies(driver, wait, builder);
		updateAllergies.verifyUpdateAllerigies(provider, recation, severity, modifyDate);
	}

	@AfterTest
	public void logOut() throws Exception {
		driver.close();
	}
}
