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
import pages.PagePMSExternalProvider;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestPMSAddExternalProvider {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	SetUp lclSetup = new SetUp();
	ExtentReports extent;
	ExtentTest test;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lclSetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.elementWaitTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "Code", "Description", "Name", "Apt", "Address", "ZipCode", "Group", "StmtGroup",
			"FeeSched", "UPIIN", "External" })
	@Test(description = "In this test cases we add external provider on pms and search on integrity EMR", priority = 1, enabled = true, dataProvider = "AdvancedMDExtProviderDetails", dataProviderClass = TestDataProviders.class)
	public void checkPMSExternalProvider(String enviorment, String code, String description, String name, String apt,
			String adddress, String zipCode, String group, String stmtGroup, String feeSched, String upiIN,
			String external) throws Exception {

		// this line is used for dev and cert enviorment
		// TestLoginAdvancedMD loginAdvancedMD =new TestLoginAdvancedMD(driver);
		// loginAdvancedMD.logInAdvacedMDPatient();

		// this line is used for only sprint-QA enviorment
		LoginTest test1 = new LoginTest(driver);
		test1.testLogin();

		new PagePMSExternalProvider(driver, wait, builder).verifyPMSExternalProvider(code, description, name, apt,
				adddress, zipCode, group, stmtGroup, feeSched, upiIN, Boolean.parseBoolean(external));
}

	// close driver
	@AfterTest
	public void logOut() {
		driver.close();
	}
}
