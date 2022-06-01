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
import pages.PageRemoveDocumentFromDocumentCenter;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestRemoveDocumentFromDocumentCenter {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
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


	//In this test cases remove document from document center
	@Parameters({ "Enviorment","FirstName", "LastName", "Provider" })
	@Test(description = "In this test cases remove document from document center", priority = 1, enabled = true, dataProvider = "RemoveDocumentDetails", dataProviderClass = TestDataProviders.class)
	public void checkRemoveDocumentFromdocumentCenter(String enviorment,String fName, String lName, String provider) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(4000);
		Boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageRemoveDocumentFromDocumentCenter removeDoc = new PageRemoveDocumentFromDocumentCenter(driver, wait,
				builder);
		removeDoc.verfiyRemoveDocument(provider);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
