package tests;


	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Reporter;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;

	import config.ProjectSettings;
import pages.PageLogIn;
import pages.PgCreatePatient;
	import pages.PgExampleOnGrid;
import pages.PgJsGridExample;
import pages.PgLanding;
	import pages.PgLogin;
	import pages.PgPatientSearch;
	import utilities.SetUp;
	import utilities.TestDataProviders;

	public class TestJsGridExample {
		String exception = null;
		public WebDriver driver;
		SetUp lsetup = new SetUp();

		PgLanding lclPgLanding;
		PgPatientSearch lclPgPatientSearch;
		PgCreatePatient lclpgCreatePatient;
		public static ExtentReports extent;
		public static ExtentTest test;
		WebDriverWait wait;
		private Actions action;

		@BeforeTest
		public void beforeTest() throws Exception {
			driver = lsetup.instBrowser(ProjectSettings.browserType.FIREFOX);
			driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@Parameters({ "baseURL", "username", "password" })
		@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
		public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
			boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
			Reporter.log(ProjectSettings.baseURL + " opened successfully.");
			PageLogIn pgLogin = new PageLogIn(driver);
			try {
				if (pgOpenStatus) {
					lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
					Reporter.log("Logged Successfully!");
				}
			} catch (Exception ex) {
				Reporter.log(ex.toString());
			}
		}

		@Parameters({ "TableLocater", "Name" })
		@Test(description = "This test logs into the application", priority = 2, enabled = true, dataProvider = "GridexampleDetails", dataProviderClass = TestDataProviders.class)
		// @Test(priority = 2)
		public void check(String tableLocater, String searchString) throws InterruptedException {
			Thread.sleep(2000);

			PgJsGridExample grid = new PgJsGridExample(driver);

			//By tableLocator=null;
			grid.searchTable(tableLocater, searchString);
			/* System.out.println(name); */
		}

		// @AfterTest
		// public void logout() {
		// driver.quit();
		// }

	}



