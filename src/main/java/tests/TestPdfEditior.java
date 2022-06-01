package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PagePdfEditior;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestPdfEditior {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extents;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;

	@BeforeTest
	//@Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// logOn to certification Site
//	@Parameters({ "baseURL", "username", "password" })
//	@Test(description = "This test logs into the application", priority = 1, enabled = true,  dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
//	public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
//		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
//		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
//		PgLogin pgLogin = new PgLogin(driver);
//		try {
//			if (pgOpenStatus) {
//				lclPgLanding = pgLogin.validLogin(usrnm, pwd);
//				Reporter.log("Logged Successfully!");
//			}
//		} catch (Exception ex) {
//			Reporter.log(ex.toString());
//		}
//	}

	@Parameters({ "Firstname", "Lastname", "Provider", "SuggestedDocument", "ActualText" })
	@Test(description = "This test cases edit the pdf", priority = 2, enabled = true,dataProvider = "pdfEditorDetails", dataProviderClass = TestDataProviders.class)
	public void verifyPdf(String fName, String lName, String provider, String suggestedDoc, String actualText)
			throws Exception {

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		PagePdfEditior editior = new PagePdfEditior(driver, wait, builder);
		editior.editPdf(provider, suggestedDoc, actualText);

		ScreenShot scr=new ScreenShot();
		ScreenShot.screen(driver);


	}

}
