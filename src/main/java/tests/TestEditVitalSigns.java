
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-232

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
import pages.PageEditVitalSigns;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestEditVitalSigns {

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

	// In this test cases edit the vital signs data and match with clinic note
	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "Temp", "BloodPressure", "Comments", "HeartRate",
			"BldcOximetry", "InhaledOxygenConcentration", "RespiratoryRate", "Height-inch", "Weight", "NewComments",
			"CreationDate" })
	@Test(description = "In this test cases edit the vital signs data and match with clinic note", priority = 2, enabled = true, dataProvider = "EditVitalSignsDetails", dataProviderClass = TestDataProviders.class)
	public void checkEditVitalSigns(String enviorment, String fName, String lName, String provider, String temp,
			String bloodPressure, String comments, String heartRate, String bldcOximetry,
			String inhaledOxygenConcentration, String respiratoryRate, String heightInch, String weight,
			String newComments, String creationDate) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Thread.sleep(4000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageEditVitalSigns editVitalSigns = new PageEditVitalSigns(wait, builder, driver);
		editVitalSigns.verifyEditVitalSigns(provider, bloodPressure, comments, heartRate, temp, bldcOximetry,
				inhaledOxygenConcentration, respiratoryRate, heightInch, weight, newComments, creationDate);

		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
