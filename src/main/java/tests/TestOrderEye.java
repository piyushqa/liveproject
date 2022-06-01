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
import pages.PageOrderEye;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestOrderEye {

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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "EyeTestcategory",
			"EyeTest", "RegardingProblem", "WhichEye", "When" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "OrderEyeTestDetails", dataProviderClass = TestDataProviders.class)
	public void checkOrderEye(String enviorment, String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String EyeTestCategory, String EyeTest,
			String regardingProblem, String WhichEye, String when) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageOrderEye(driver, wait, builder).verifyOrderEye(category, subCategory1, subCategory2, eye,
				galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
				Boolean.parseBoolean(noCharges), EyeTestCategory, EyeTest, regardingProblem, WhichEye, when);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
