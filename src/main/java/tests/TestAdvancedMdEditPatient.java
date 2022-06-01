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
import pages.PageAdvancedMDEditPatient;
import pages.PgAdvancedMDPatient;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAdvancedMdEditPatient {
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
	// public static ExtentTest test;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "Name", "Type", "Status" })

	@Test(description = "This test create the patient on AdvancedMd and match the MRN", priority = 1, enabled = true, dataProvider = "AdvancedMdEditPatientDetails", dataProviderClass = TestDataProviders.class)
	public void checkAdvancedMDPatinet(String Enviorment, String name,String type, String status) throws Exception {

		// this line is used for dev and cert enviorment
		// Thread.sleep(5000);
		// TestLoginAdvancedMD pmsMD = new TestLoginAdvancedMD(driver);
		// pmsMD.logInAdvacedMDPatient();

		// this line is used for only sprint-QA enviorment
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		PageAdvancedMDEditPatient editPatient=new PageAdvancedMDEditPatient(driver, wait, builder);
		editPatient.verifyEditPMSPatient(name, type, status);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}
}
