package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageCanSendNotifyProviderLettersOutsideTheEncounter;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestCanSendNotifyProviderLettersOutsideTheEncounter {

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

	@Parameters({ "Enviorment", "UserName", "Pasword", "FirstName", "LastName", "Category", "SubCategory1",
			"SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType",
			"NoCharges" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "NPLOutsideEncounterDetails", dataProviderClass = TestDataProviders.class)
	public void checkNotifyProviderLettersOutsideTheEncounter(String Enviorment, String userName, String password,
			String fName, String lName, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, String significantProblem, String visitType,
			String noCharges) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageCanSendNotifyProviderLettersOutsideTheEncounter(driver, wait, builder)
				.verifyNotifyProviderLettersOutsideTheEncounter(userName, password, fName, lName, category,
						subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
						Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges));

	}

}
