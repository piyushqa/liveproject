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
import pages.PageReconFin;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestReconFin {
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

	@Parameters({ "Enviorment", "Providername", "ProviderPassword", "MustHaveSupervising",
			"SuperVisingDocterCanCloseEncounter", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2",
			"Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem", "PlanLiberay", "SubPlanLiberay",
			"VisitType", "NoCharges","SuperVisingProvider"})
	@Test(description = "In this scenario we add recon fin tes cases", priority = 1, enabled = true, dataProvider = "ReconFinDetails", dataProviderClass = TestDataProviders.class)
	public void checkReconFin(String enviorment, String providerName, String providerPswd, String mustHaveSuperVising,
			String superVisingDocterCanCloseEncounter, String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges,String superVisingProvider) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageReconFin(driver, wait, builder).verifyRecoNFin(providerName, providerPswd,
				Boolean.parseBoolean(mustHaveSuperVising), Boolean.parseBoolean(superVisingDocterCanCloseEncounter),
				fName, lName, category, subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges),superVisingProvider);
	}
}
