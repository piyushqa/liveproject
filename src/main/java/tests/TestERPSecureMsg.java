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
import pages.PageERPSecureMsg;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestERPSecureMsg {
	String exception = null;
	private WebDriverWait wait;
	private WebDriver driver;
	Actions builder;
	ScreenShot shot;
	ExtentReports extent;
	ExtentTest test;
	SetUp lsetup = new SetUp();

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	// In this test cases send msg Integrity EMR to ERP and reply from ERP to EMR
	@Parameters({ "Enviorment","MsgTO", "OtherRecipites", "Topic", "FirstName", "LastName", "ERPUserName", "ERPPassword", "Urgent" })
	@Test(description = "In this test cases send msg Integrity EMR to ERP and reply from ERP to EMR", priority = 1, enabled = true, dataProvider = "ERPSecureMsgDetails", dataProviderClass = TestDataProviders.class)
	public void checkERPSecureMsg(String enviorment,String msgTo, String otherRecipites, String topic, String fName, String lName,
			String erpUserName, String erpPassword, String urgent) throws Exception {

		// login in Integrity EMR
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);
		PageERPSecureMsg secureMsg = new PageERPSecureMsg(driver, wait, builder);
		secureMsg.verifyERPSecureMsg(msgTo, otherRecipites, topic, fName, lName, erpUserName, erpPassword,
				Boolean.parseBoolean(urgent));
		Thread.sleep(2000);
		ScreenShot shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
