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
import pages.PageSensoromotorExam;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSensorimotorExam {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder=new Actions(driver);
	}

	
	// This test check Sensorimotor Exam
	@Parameters({ "Enviorment","FirstName", "Lastname", "Provider", "Exam", "ExcpectedValue", "Motility", "Alignment",
			"OtherAlignMent", "OtherAlignment2", "Convergence", "Divergence", "NearPoint", "Operation", "Fly",
			"Circles", "Animals", "Lang", "DropDown", "Other", "Distance", "Near", "Fixation", "Nystagmus", "Comment1",
			"Comment2", "Comment3", "Interpretation", "Quries", "Righteye", "Lefteye", "HeadPosition" })
	@Test(description = "This test check Sensorimotor Exam", priority = 2, enabled = true, dataProvider = "SensorimotorExamDetails", dataProviderClass = TestDataProviders.class)
	public void checkSensorimotorExam(String enviorment,String fName, String lName, String provider, String exam, String expectedValue,
			String motility, String alignment, String otherAlignment, String otherAlignMent2, String alignmentText,
			String convergence, String divergence, String nearPoint, String Operation, String fly, String circles,
			String animals, String lang, String dropdown, String other, String distance, String near, String fixation,
			String nystagmus, String comment1, String comment2, String comment3, String interpretation, String quries,
			String rightEye, String leftEye, String headPosition) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		Thread.sleep(2000);
		PageSensoromotorExam sensExam = new PageSensoromotorExam(driver, wait, builder);

		sensExam.fillSensormotorExam(provider, exam, expectedValue, Integer.parseInt(motility), alignment,
				otherAlignment, otherAlignMent2, alignmentText, convergence, divergence, nearPoint,
				Boolean.parseBoolean(Operation), fly, circles, animals, lang, dropdown, other, distance, near, fixation,
				nystagmus, comment1, comment2, comment3, interpretation, quries, rightEye, leftEye, headPosition);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// After Test Close driver
	@AfterTest
	public void logOut() {
		driver.close();
	}

}
