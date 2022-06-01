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
import pages.PageTechExam;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestTechEaxm {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;
	SetUp lsetUp = new SetUp();
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "MRN", "Provider", "IopOD", "IopOS", "Mood", "Orientation", "Comment1", "Comment2",
			"Quries", "LeftEye", "ValueOAandOS", "Centeral", "Peripheral" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "TechExamDetails", dataProviderClass = TestDataProviders.class)
	public void verifyTechExam(String Enviorment, String mrn, String provider, String iopOD, String iopOS, String mood,
			String orientation, String comment1, String comment2, String quries, String rightEye, String leftEye,
			String ValueODAndOS, String centeral, String peripheral) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient("", "", mrn, editPatient);

		new PageTechExam(driver, wait, builder).verifyTechExam(provider, iopOD, iopOS, mood, orientation, comment1,
				comment2, quries, rightEye, leftEye, ValueODAndOS, centeral, peripheral);
	}

//	@AfterTest
//	public void logOut() throws Exception {
//		driver.close();
	//}
}
