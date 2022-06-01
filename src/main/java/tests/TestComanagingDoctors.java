package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageComanagingDoctors;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestComanagingDoctors {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	Actions builder;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorments", "ProviderType", "SelectDegree", "ProviderFirstName", "ProviderLastName", "initials",
			"Npi", "Refferalcode", "Specialty", "AddressLine1", "AddressLine2", "City", "State", "ZipCode",
			"offocephone", "FirstName", "LastName", "Provider" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "ComanagingDoctorsDetails", dataProviderClass = TestDataProviders.class)
	public void checkComanagingDoctors(String Enviorments, String ProviderType, String SelectDegree,
			String ProviderFirstName, String ProviderLastName, String initials, String Npi, String Refferalcode,
			String Specialty, String AddressLine1, String AddressLine2, String City, String State, String ZipCode,
			String offocephone, String fName, String lName, String providerName) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageComanagingDoctors(wait, driver, builder).verifyComanagingDoctors(ProviderType, SelectDegree,
				ProviderFirstName, ProviderLastName, initials, Npi, Refferalcode, Specialty, AddressLine1, AddressLine2,
				City, State, ZipCode, offocephone, fName, lName, providerName);
	}

}
