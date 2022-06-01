
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-199

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
import pages.PageLogIn;

import pages.PageSendingPatientEduaction;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSendingPatientEduaction {
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
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder=new Actions(driver);
	}

	@Parameters({ "Enviorment", "Firstname", "Lastname", "Provider", "SuggestedDocument", "ActualText", "VisitType",
			"Nocahrges", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability",
			"significantProblem" })
	@Test(description = "This test cases edit the pdf", priority = 1, enabled = true, dataProvider = "PatientEducationDetails", dataProviderClass = TestDataProviders.class)
	public void checkSendingPatientEducation(String enviorment, String fName, String lName, String provider,
			String suggestedDoc, String actualText, String visitType, String noCharges, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		PageSendingPatientEduaction patientEducation = new PageSendingPatientEduaction(driver, wait, builder);
		patientEducation.verifyPatientEducation(provider, suggestedDoc, actualText, visitType,
				Boolean.parseBoolean(noCharges),category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem));
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}
