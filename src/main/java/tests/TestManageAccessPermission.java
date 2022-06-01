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
import pages.PageManageAccessPermission;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestManageAccessPermission {

	SetUp lsetUp = new SetUp();
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	ExtentReports extent;
	ExtentTest test;
	ScreenShot shot;
	public static String DEV_KEY = "e83385bde39a08fa5cce099137c8ebd2"; //Your API Key
	public static String SERVER_URL = "http://128.136.92.176/testlink/index.php?caller=login&viewer="; //your testlink server url
	public static String PROJECT_NAME = "IntegrityEMR"; 
	public static String PLAN_NAME = "Testing";
	public static String BUILD_NAME = "TestBuild";

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);

	}

	@Parameters({ "Enviorment", "UserNameAllowed", "AtLeastOneNumber", "AtLeastSpecialChar", "ProviderName",
			"ProviderPswd" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "ManageAccessPermissionDetails", dataProviderClass = TestDataProviders.class)
	public void checkManageAccessPermission(String enviorment, String userNameAllowed, String atLeastOneNumber,
			String atleastSplChar, String providerName, String providerPswd) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageManageAccessPermission(driver, wait, builder).verifyManageAccessPermission(
				Boolean.parseBoolean(userNameAllowed), Boolean.parseBoolean(atLeastOneNumber),
				Boolean.parseBoolean(atleastSplChar), providerName, providerPswd);

	}

//	@AfterTest
//	public void logOut()throws Exception{
//		driver.close();
//	}
}
