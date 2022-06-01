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
import pages.PageDemographicsChangeRequestFromPortal;
import pages.PgErpLanding;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestDemographicsChangesRequestFromPortal {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgErpLanding lclErpLanding;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment","ChangeAddress2","TaskStatus"})
	@Test(description = "Demographics change request from portal", priority = 1, enabled = true, dataProvider = "DemoGraphicsChangePortalDetails", dataProviderClass = TestDataProviders.class)
	public void checkDemographicsChangeRequestFromPortal(String enviorment, String changeAddress2, String taskStatus) throws Exception {
		TestErpLogin test1 = new TestErpLogin(driver);
		test1.testLogin();

		new PageDemographicsChangeRequestFromPortal(driver, builder, wait).verifyDemographicsChangeRequestFromPortal(changeAddress2,taskStatus);

	}
	
	@AfterTest
	public void logOut(){
		driver.close();
	}
}
