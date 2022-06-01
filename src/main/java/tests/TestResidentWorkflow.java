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
import pages.PageResidentWorkflow;
import pages.PgLanding;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestResidentWorkflow {

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

	@Parameters({ "Enviorment", "Providername", "ProviderPassword", "MustHaveSupervising",
			"SuperVisingDocterCanCloseEncounter", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2",
			"Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "WithOrWithoutSupervisingProvideDetails", dataProviderClass = TestDataProviders.class)
	public void checkResidentWorkflow(String enviorment, String providerName, String providerPswd,
			String mustHaveSuperVising, String superVisingDocterCanCloseEncounter, String fName, String lName,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, String significantProblem, String visitType, String noCharges) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageResidentWorkflow(driver, wait, builder).verifyResidentWorkflow(providerName, providerPswd,
				Boolean.parseBoolean(mustHaveSuperVising), Boolean.parseBoolean(superVisingDocterCanCloseEncounter),
				fName, lName, category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges));
	}

//	@AfterTest 
//	public void logOut() {
//		driver.close();
//	}
}
