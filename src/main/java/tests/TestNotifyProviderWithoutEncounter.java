package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageNotifyProviderWithoutEncounter;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestNotifyProviderWithoutEncounter {

	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "DownloadPath", "FileName", "sendingProvder", "Name",
			"Refferal", "Comments", "Documents" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "NotifyProviderWithoutEncounterDetails", dataProviderClass = TestDataProviders.class)
	public void checkNotifyProviderWithoutEncounter(String enviorment, String fName, String lName, String downloadPath,
			String fileName, String sendingProvider, String name, String refferal, String comments, String documents)
			throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		new PageNotifyProviderWithoutEncounter(wait, driver, builder).verifyNotifyProviderWithoutEncounter(fName, lName,
				downloadPath, fileName, sendingProvider, name, Boolean.parseBoolean(refferal), comments, documents);

	}
}
