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
import pages.PageAdvanceSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAdvanceSearch {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	SetUp lsetUp = new SetUp();
	ExtentReports extent;
	ScreenShot shot;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	//check AdvanceSearch
	@Parameters({ "Enviorment", "MRN", "Appointment", "Date", "AllergyWith", "AllergyName" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "AdvanceSrchDetails", dataProviderClass = TestDataProviders.class)
	public void checkAdvanceSearch(String Enviorment, String mrn, String appointment, String date, String allergyWith,
			String allergyName) throws Exception {

		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		new PageAdvanceSearch(driver, wait, builder).verifyAdvanceSearch(mrn, appointment, date, allergyWith,
				allergyName);

	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
