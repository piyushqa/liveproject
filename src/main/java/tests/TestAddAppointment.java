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
import pages.PageAddAppointment;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddAppointment {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
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

	@Parameters({ "Enviorment", "MRN", "VisitType", "Date", "AppointMentDate" })
	@Test(description = "In this test cases we add an appointment and delete them", priority = 1, enabled = true, dataProvider = "AddApointment1Details", dataProviderClass = TestDataProviders.class)
	public void checkAddAppointMent(String Enviorment, String mrn, String visitType, String date, String appointment)
			throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageAddAppointment(driver, wait, builder).verifyAddAppointment(mrn, visitType, date, appointment);
	}

	@AfterTest
	public void logOut() {
		driver.close();

	}
}
