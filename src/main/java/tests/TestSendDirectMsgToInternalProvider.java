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

import pages.PageSendDirectMsgtoProvider;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSendDirectMsgToInternalProvider {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
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

	@Parameters({ "Enviorment","FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "Name", "Refferal", "Comments",
			"Provider", "ExProviderName" })
	@Test(description = "In this test we add notify provider and send direct msg to provider ", priority = 1, enabled = true, dataProvider = "DirectMessageToProviderDetails", dataProviderClass = TestDataProviders.class)
	public void checkDirectMsgToProvider(String enviorment,String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String name, String refferal,
			String comments, String provider, String exProviderName) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageSendDirectMsgtoProvider internalProvider = new PageSendDirectMsgtoProvider(wait, driver, builder);
		internalProvider.verifySendDirectMsgtoInternalProvider(category, subCategory1, subCategory2, eye,
				galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
				Boolean.parseBoolean(noCharges), name, Boolean.parseBoolean(refferal), comments, provider,
				exProviderName);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);
	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}