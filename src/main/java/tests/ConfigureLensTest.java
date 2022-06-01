package tests;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pages.PgConfigureCustomLens;

import pages.PgCreatePatient;
import pages.PgDeletePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import pages.PgVisionSummary;

import utilities.SetUp;
import utilities.TestDataProviders;

public class ConfigureLensTest {
	private Actions action;
	String exception = null;
	public WebDriver driver;

	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Parameters({ "baseURL", "username", "password" })
//	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
//	public void testLogin(String baseURL, String usrnm, String pwd) throws Exception {
//		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
//		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
//		PageLogIn pgLogin = new PageLogIn(driver);
//		try {
//			if (pgOpenStatus) {
//				lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
//				Reporter.log("Logged Successfully!");
//			}
//		} catch (Exception ex) {
//			Reporter.log(ex.toString());
//
//		}
//	}

	@Parameters({ "FirstName", "LastName", "Provider", "Vision", "AddNew", "CustomLens", "CustomLenses",
			"ShowFavourites", "Customlenseditior" })
	@Test(priority = 2, enabled = true, dataProvider = "configureLensDetails", dataProviderClass = TestDataProviders.class)
	public void testConfigureLens(String fName, String lName, String provider, String vision, String AddNew,
			String customLenses, String CustomLenses, String showFavourites, String customLensEditior)
			throws Exception {
		{
			LoginTest test = new LoginTest(driver);
			test.testLogin();

			// call patientSearch method
			Thread.sleep(2000);
			lclPgLanding = new PgLanding(driver);
			boolean editPatient = false;
			lclPgPatientSearch = lclPgLanding.patientSearch();
			lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
			// Create object of class
			PgConfigureCustomLens pgconfigurelens = new PgConfigureCustomLens(driver, wait, action);
			// call method
			pgconfigurelens.configureLens( provider, vision, AddNew, CustomLenses, CustomLenses,
					showFavourites, customLensEditior);
		}
	}

}
