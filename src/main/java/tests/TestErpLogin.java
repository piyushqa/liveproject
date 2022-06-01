package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PgErpLanding; 
import config.ProjectSettings;
import pages.PageErpLogin;
import pages.PgLogin;
import pages.PgPMSLoging;
import utilities.SetUp;

public class TestErpLogin {
	WebDriver driver;
	SetUp lsetup=new SetUp();
	PgErpLanding lclPgLanding;
	
	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// ExtentReports report=new ExtentReports("./test-output/");

	}


	

	//	@Parameters({ "baseURL", "username", "password" })
//	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	@Test(description = "This test logs into the application", priority = 1, enabled = true)
	//public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
		 public void testLogin() throws Exception {
		//boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		boolean pgOpenStatus = lsetup.getPage(driver, ProjectSettings.erpUrl);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");

		PageErpLogin erpLog=new PageErpLogin(driver);
		try {
			if (pgOpenStatus) {
				 //lclPgLanding = pgLogin.validLogin(usrnm, pwd);
				lclPgLanding = erpLog.validLogin();

				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}

		
	}
	public TestErpLogin(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
