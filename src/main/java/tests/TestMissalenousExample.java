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
import pages.PageMissalenousExample;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestMissalenousExample {
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

	//check Missalenous function
	@Parameters({ "Enviorment", "FirstName", "LastName", "MRN", "Gender", "DOB", "SSN", "Value" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "MissleanousExampledetails", dataProviderClass = TestDataProviders.class)
	public void checkMissalenous(String enviorment, String fName, String lName, String mrn, String gender, String dob,
			String ssn, String value) throws Exception {
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageMissalenousExample(driver, builder, wait).verifyMissleanous(fName, lName, mrn, gender, dob, ssn,value);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
