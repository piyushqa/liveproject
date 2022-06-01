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
import pages.PageReconDashBoard;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestReconDashBoard {
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

	@Parameters({ "Enviorment", "SelectDate", "Status" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "ReconDashBoardDetails", dataProviderClass = TestDataProviders.class)
	public void checkRecondashBoardData(String enviorment, String selectDate, String status) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageReconDashBoard(driver, wait, builder).verifyRecondashBoard(selectDate, status);

	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
