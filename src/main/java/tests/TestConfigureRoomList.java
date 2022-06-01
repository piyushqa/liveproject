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
import pages.PageConfigureRoomList;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestConfigureRoomList {
	Actions builder;
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "AddNewItem" })
	@Test(description = "In this test caes we add configure room and match the data from patient dashboard loctaion dropdown", enabled = true, priority = 1, dataProvider = "ConfigureRoomListDetails", dataProviderClass = TestDataProviders.class)
	public void checkConfigureRoomList(String enviorment, String fName, String lName, String provider,
			String addNewItem) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageConfigureRoomList(driver, wait, builder).verifyPageConfigureRoomList(fName, lName, provider,
				addNewItem);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
