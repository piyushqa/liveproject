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
import pages.PageSurgeryModuleWithTemplate;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestSurgeryModuleWithTemplate {
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

	@Parameters({ "Enviorments", "TemplateName", "ReNameTemplate" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "SurgeryWithTemplateDetails", dataProviderClass = TestDataProviders.class)
	public void checkSurgeryModuleWithTemplate(String enviorments, String tempalteName, String renameTemplate)
			throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageSurgeryModuleWithTemplate(driver, wait, builder).verifySurgeryModuleWithTemplate(tempalteName,
				renameTemplate);

	}
}
