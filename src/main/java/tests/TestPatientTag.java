package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import pages.PgPatientTag;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestPatientTag {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions action;
	public ScreenShot shot;

	@BeforeTest

	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	

	// This test check the PatientTag

	@Parameters({"Enviorment","Tag", "MypatientTags1", "MypatientTags2", "MypatientTags3", "MypatientTags4", "MypatientTags5",
			"PatientName", "PatientTags1", "PatientTags2", "FirstName", "LastName" })
	@Test(description = "This test check the PatientTag", priority = 2, enabled = true, dataProvider = "PatientTagsDetails", dataProviderClass = TestDataProviders.class)
	public void checkPatientTag(String enviorment,String tag, String myPatientTags1, String mypatientTags2, String mypatientTags3,
			String mypatientTags4, String mypatientTags5, String patientName, String pateintTags1, String pateintTags2,
			String fName, String lName) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		PgPatientTag patientTag = new PgPatientTag(driver, wait);
		patientTag.verifyPatientTag(tag, Boolean.parseBoolean(myPatientTags1), Boolean.parseBoolean(mypatientTags2),
				Boolean.parseBoolean(mypatientTags3), Boolean.parseBoolean(mypatientTags4),
				Boolean.parseBoolean(mypatientTags5), patientName, pateintTags1, pateintTags2, fName, lName);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// close driver
//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}

}
