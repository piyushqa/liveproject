
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-231

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
import pages.PageAddVitalSigns;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddVitalSigns {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	public ScreenShot shot;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "BloodPressure", "Comments", "HeartRate", "Temp",
			"BldcOximetry", "InhaledOxygenConcentration", "RespiratoryRate", "Height-inch", "Weight", "NewComments",
			"CreationDate" })
	@Test(description = "In this test cases add the vital signs data and match with clinic note", priority = 2, enabled = true, dataProvider = "VitalSignsDetails", dataProviderClass = TestDataProviders.class)
	public void checkVitalSigns(String enviorment, String fName, String lName, String provider, String bloodPressure,
			String comments, String heartRate, String temp, String bldcOximetry, String inhaledOxygenConcentration,
			String respiratoryRate, String heightInch, String weight, String newComments, String creationDate)
			throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageAddVitalSigns vitalSigns = new PageAddVitalSigns(driver, wait, builder);
		vitalSigns.verifyVitalSigns(provider, bloodPressure, comments, heartRate, temp, bldcOximetry,
				inhaledOxygenConcentration, respiratoryRate, heightInch, weight, newComments, creationDate);
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}
