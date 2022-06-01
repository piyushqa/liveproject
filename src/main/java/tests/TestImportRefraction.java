
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-176

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
import pages.PageImportRefraction;
import pages.PgCreatePatient;

import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestImportRefraction {
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
	}

	

	// In this test case import refraction from vision Tab
	@Parameters({ "Enviorment","Firstname", "Lastname", "Provider", "ImportData", "Deletedata" })
	@Test(description = "In this test case import refraction from vision Tab", priority = 2, enabled = true, dataProvider = "ImportRefractionDetails", dataProviderClass = TestDataProviders.class)
	public void checkImportRefraction(String enviorment,String fName, String lName, String provider, String importData, String deleteData)
			throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(5000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageImportRefraction impRef = new PageImportRefraction(driver, wait, builder);
		impRef.verifyImportRefraction(provider, importData, deleteData);

		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}
