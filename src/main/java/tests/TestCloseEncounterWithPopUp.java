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
import pages.PageCloseEncounterWithPopUp;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestCloseEncounterWithPopUp {

	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	Actions builder;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "PlanLiberay", "SubPlanLiberay", "VisitType",
			"NoCharges", "ConsultNote", "HistoryAndPhysical", "ProgressNote" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "CloseEncounterWithPopUpDetails", dataProviderClass = TestDataProviders.class)
	public void checkCloseEncounterWithPopUp(String enviorments, String fName, String lName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String ConsultNote,
			String HistoryAndPhysical, String ProgressNote) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageCloseEncounterWithPopUp(wait, driver, builder).verifyCloseEncounterWithPopUp(fName, lName, category,
				subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges),
				Boolean.parseBoolean(ConsultNote), Boolean.parseBoolean(HistoryAndPhysical),
				Boolean.parseBoolean(ProgressNote));
	}

	@AfterTest
	public void logOut() {
		// if (driver != null) {
		driver.close();
		// }
	}

}
