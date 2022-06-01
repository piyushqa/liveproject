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
import pages.PageLogOutAndHold;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestLogOutAndHold {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgPatientSearch lclPgPatientSearch;
	PgLanding lclPgLanding;
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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "Text1", "Text2", "Text3" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "LogOutAndHoldDetails", dataProviderClass = TestDataProviders.class)
	public void checkLogOutAndHold(String emviorment, String fName, String lName, String provider, String text1,
			String text2, String text3) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(2000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		new PageLogOutAndHold(driver, wait, builder).verfiyPageLogOutAndHold(provider, text1, text2, text3,fName,lName);

	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
	//}
}
