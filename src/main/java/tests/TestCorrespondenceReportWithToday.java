
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-233

package tests;

import java.util.Date;
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
import pages.PageCorrespondenceReportWithTodays;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestCorrespondenceReportWithToday {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// In This test case create Correspondence report with today(CurrentDate)
	@Parameters({ "Enviorment","FirstName", "LastName", "CorrospondenceType", "Text", "MatchAge", "DOB", "View" })
	@Test(description = "In This test case create Correspondence report with today(CurrentDate)", priority = 1, enabled = true, dataProvider = "CorrespondenceReportTodaysdetails", dataProviderClass = TestDataProviders.class)
	public void checkCorrespondenceReportWithToday(String enviorment,String fName, String lName, String corrospondenceType, String text,
			String matchAge, String dob, String view) throws Exception {

		// Call Login Method
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		// call patient Search Method
		Thread.sleep(5000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		// call verifyCorrespondenceReportWithTodays Method
		PageCorrespondenceReportWithTodays reportWithTodays = new PageCorrespondenceReportWithTodays(wait, driver,
				builder);
		reportWithTodays.verifyCorrespondenceReportWithTodays(corrospondenceType, text, matchAge, dob, view);
		Thread.sleep(2000);
		ScreenShot shot = new ScreenShot();
		ScreenShot.screen(driver);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
