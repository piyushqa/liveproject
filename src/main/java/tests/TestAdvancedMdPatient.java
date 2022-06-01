package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PgAdvancedMDPatient;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAdvancedMdPatient {
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
		builder=new Actions(driver);
	}

		// This test create the patient on AdvancedMd and match the MRN
	@Parameters({"Enviorment", "Name", "AptSte", "Address", "Zip", "Gender", "Email", "Confidential", "Note", "MaterialStatus",
			"SSN", "MRN", "Month", "Year", "Day", "Type", "Status"

	})

	@Test(description = "This test create the patient on AdvancedMd and match the MRN", priority = 2, enabled = true, dataProvider = "AdvancedMDCreatePatientDetails", dataProviderClass = TestDataProviders.class)
	public void checkAdvancedMDPatinet(String Enviorment,String name, String aptSte, String address, String zip, String gender,
			String email, String confidential, String note, String materialStatus, String ssn, String mrn, String month,
			String year, String day, String type, String status) throws Exception {

		//this line is used for dev and cert enviorment
	Thread.sleep(5000);
		TestLoginAdvancedMD pmsMD = new TestLoginAdvancedMD(driver);
		pmsMD.logInAdvacedMDPatient();

	//	this line is used for only sprint-QA enviorment
//		LoginTest test = new LoginTest(driver);
//		 test.testLogin();

		Thread.sleep(3000);
		PgAdvancedMDPatient mdPatient = new PgAdvancedMDPatient(driver, wait,builder);
		mdPatient.createPatientMd(name, aptSte, address, zip, gender, email, confidential, note, materialStatus, ssn,
				mrn, month, year, day, type, status);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	 //close Driver
//	 @AfterTest
//	 public void logout() {
//	 driver.close();
//
//	 }

}
