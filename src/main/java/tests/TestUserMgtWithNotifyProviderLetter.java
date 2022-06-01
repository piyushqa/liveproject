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
import pages.PageUserMgtWithNotifyProviderLetter;
import pages.PgLanding;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestUserMgtWithNotifyProviderLetter {
	SetUp lsetUp = new SetUp();
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPglanding;
	ExtentReports extent;
	ExtentTest test;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);

	}

	@Parameters({ "Enviorments", "ProviderName", "NotifyProviderTemplate", "PatientLink", "ProviderLink",
			"EncounterLink", "VisionLink", "TechExamLink", "ExamLink", "ImpAndPlanLink", "FirstName", "LastName",
			"Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability",
			"significantProblem", "VisitType", "NoCharges", "Name", "Refferal", "Complete", "Direct" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "UserMgtWithNotifyProviderDetails", dataProviderClass = TestDataProviders.class)
	public void checkUserMgtWithNotifyProviderLetter(String Enviormnets, String providerName,
			String notifyProviderTemplate, String patientLink, String providerLink, String encounterLink,
			String visionLink, String techExamLink, String examLink, String impAndPlanLink, String fName, String lName,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, String significantProblem, String visitType, String noCharges, String name,
			String refferal, String complete, String direct) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageUserMgtWithNotifyProviderLetter(driver, wait, builder).verifyUserMgtWithNotifyProviderLetter(
				providerName, Boolean.parseBoolean(notifyProviderTemplate), patientLink, providerLink, encounterLink,
				visionLink, techExamLink, examLink, impAndPlanLink, fName, lName, category, subCategory1, subCategory2,
				eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
				Boolean.parseBoolean(noCharges), name, Boolean.parseBoolean(refferal), Boolean.parseBoolean(complete),
				Boolean.parseBoolean(direct));

	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
