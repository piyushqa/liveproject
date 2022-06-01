package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageAuditSearch;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAuditSearch {
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

	@Parameters({"Enviorment","Fromdate", "ToDate", "MRN", "User", "ActivityType", "Actions" })
	@Test(description = "In this test case find the audit search data", priority = 1, enabled = true, dataProvider = "AuditSearchDetails", dataProviderClass = TestDataProviders.class)
	public void checkAuditserach(String enviorment,String fromDate, String toDate, String mrn, String user, String activityType,
			String action) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		PageAuditSearch auditsearch = new PageAuditSearch(driver, wait, builder);
		auditsearch.verifyAuditsearch(fromDate, toDate, mrn, user, activityType, action);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);
	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
