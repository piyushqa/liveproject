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
import pages.PageScheduledAnAppointment;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestScheduledAnAppointment {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	public ScreenShot shot;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({"Day","Date"})
	@Test(description = "", priority = 1, enabled = true, dataProvider = "SchedularAppointmentDetails", dataProviderClass = TestDataProviders.class)
	public void checkScheduledAppointment(String day,String date) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		PageScheduledAnAppointment scheduledAppointment = new PageScheduledAnAppointment(wait, driver, builder);
		scheduledAppointment.checkScheduledAppointment(day,date);
	}

}
