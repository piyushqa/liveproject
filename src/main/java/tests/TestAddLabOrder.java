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
import pages.PageAddAndDeleteExistingGlass;
import pages.PageAddLabOrder;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddLabOrder {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder=new Actions(driver);
	}

	
	@Parameters({"Enviorment","FirstName", "LastName", "Provider", "SelectlabTest", "Comments", "AssociatesLabWithProblem",
			"Designatetime","Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "VisitType", "NoCharges"})
	@Test(description = "In this test cases add lab order details and match with clinic note", priority = 1, enabled = true, dataProvider = "AddLabOrderDetails", dataProviderClass = TestDataProviders.class)
	public void checkAddLabOrder(String enviorment,String fName, String lName, String provider, String selectlabTest, String comments,
			String associatesLabWithProblem, String designateTime,String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem,String visitType, String noCharges) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageAddLabOrder labOrder = new PageAddLabOrder(driver, wait, builder);
		labOrder.verifyAddLabOrder(provider, selectlabTest, comments, associatesLabWithProblem, designateTime,category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem),visitType,
				Boolean.parseBoolean(noCharges));
	}
}
