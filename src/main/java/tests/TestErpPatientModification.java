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
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgPatientSearch;
import pages.PageErpPatientModification;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestErpPatientModification {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;

	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "ModifyName", "Date", "email", "MethodOfContact", "Account",
			"CalenderDate", "ZIPCODE", "NEWUSERNAME", "NewPswd", "ConfirmNewPswd" })

	@Test(description = "This test encounter the patient and submit", priority = 1, enabled = true, dataProvider = "PatientModificationDetails", dataProviderClass = TestDataProviders.class)
	public void checkErpPatientModification(String enviorment, String fName, String lName, String modifyFname,
			String Date, String email, String methodOfContact, String account, String calenderDate, String Zipcode,
			String newUserName, String newPswd, String ConfirmNewPswd) throws Exception {

		
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(5000);
		boolean editPatient = true;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		Thread.sleep(2000);
		PageErpPatientModification patientModify = new PageErpPatientModification(driver, wait, builder);
		patientModify.modifyPatientRecord(modifyFname, Date, email, methodOfContact, account, Zipcode, newUserName,
				newPswd, ConfirmNewPswd, calenderDate);
		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	@AfterTest
	public void logout() {
		driver.close();
	}

}
