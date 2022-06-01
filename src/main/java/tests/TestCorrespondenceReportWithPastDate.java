
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-234

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
import pages.PageAddAndDeleteExistingGlass;
import pages.PageCorrespondenceReportWithPastDate;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestCorrespondenceReportWithPastDate {
	String exception = null;
	public WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PageAddAndDeleteExistingGlass addAndDelEG = null;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// ExtentReports report=new ExtentReports("./test-output/");

	}

	@Parameters({"Enviorment","FirstName", "LastName", "CorrospondenceType", "Text", "MatchAge", "DOB", "View" })
	@Test(description = "In This test case create Correspondence report with today(PastDate)", priority = 1, enabled = true, dataProvider = "CorrespondenceReportWithPastDayDetails", dataProviderClass = TestDataProviders.class)
	public void checkCorrespondenceReportWithPastDate(String enviorment,String fName, String lName, String corrospondenceType,
			String text, String matchAge, String dob, String view) throws Exception {

		// Call Login Method
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		// call patient Search Method
		Thread.sleep(4000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageCorrespondenceReportWithPastDate reportWithPastDate = new PageCorrespondenceReportWithPastDate(wait, driver,
				builder);
		reportWithPastDate.verifyCorrespondenceReportWithPastDate(corrospondenceType, text, matchAge, dob, view);
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	 @AfterTest
	 public void logout() {
	 driver.close();
	 }
}
