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
import pages.PageAddFamilyHistory;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestFamilyHistory {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgPatientSearch lclPgPatientSear;
	PgLanding lclPgLanding;
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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "RelationShip", "Eyeproblems", "Medicalproblem" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "FamilyHistoryDetails", dataProviderClass = TestDataProviders.class)
	public void checkCCHPI(String enviorment, String fName, String lName, String provider, String relationship,
			String eyeProblems, String medicalProblems) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSear = lclPgLanding.patientSearch();
		lclPgPatientSear.searchPatient(fName, lName, "", editPatient);

		new PageAddFamilyHistory(wait, driver, builder).performFamilyHistory(provider, relationship, eyeProblems,
				medicalProblems);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}

}
