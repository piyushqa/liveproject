package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;

public class PatientSearchTest
{
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;

    @BeforeTest
	public void beforeTest() throws Exception
	{
        driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
        driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}

    @Parameters({"username", "password"})
	@Test(description = "This test logs into the application", priority=1, enabled=true)
	public void tstLogin(String usrnm, String pwd) throws Exception
	{
		boolean pgOpenStatus = lsetup.getPage(driver, ProjectSettings.baseURL);
		Reporter.log(ProjectSettings.baseURL+" opened successfully.");
		PageLogIn pgLogin = new PageLogIn(driver);
		try
	    {
		   if (pgOpenStatus)
		   {
			   lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
			   Reporter.log("Logged Successfully!");
		   }
	    }
		catch (Exception ex)
	    {
			Reporter.log(ex.toString());
	    }
	}

    @Parameters({"searchPatientFName", "searchPatientLName"})
    @Test(description="Test to search for patient on Patient Search page", priority=2, enabled=true)
    public void tstSearchPatient(String searchPatientFName, String searchPatientLName) throws Exception
    {
    	lclPgPatientSearch = lclPgLanding.patientSearch();
    	lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "", false);
    }

    @AfterTest
    public void tearDown() throws Exception
    {
    	/*extent.endTest(test);
    	extent.flush();
    	extent.close(); */
    	driver.close();
    }
}
