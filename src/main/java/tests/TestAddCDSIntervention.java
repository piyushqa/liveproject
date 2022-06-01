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
import pages.PageAddCDSIntervention;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddCDSIntervention {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
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

	@Parameters({ "Enviorment", "RuleName", "UserTypeList", "InfoBtn", "Education", "Intervention", "Criticality",
			"FileName", "Smoking", "TriggerOn", "Patient", "Smoker" })
	@Test(description = "In this test cases we add cds and then match data in patient education", priority = 1, enabled = true, dataProvider = "AddCDSDetails", dataProviderClass = TestDataProviders.class)
	public void checkCDSIntervention(String enviorment, String ruleName, String userTypeList, String infoBtn,
			String education, String Intervention, String criticality, String FileName, String smoking,
			String triggerOn, String patient, String smoker) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageAddCDSIntervention(driver, wait, builder).verifyAddCDSIntervention(ruleName, userTypeList, infoBtn,
				Boolean.parseBoolean(education), Boolean.parseBoolean(Intervention), criticality, FileName, smoking,
				triggerOn, patient, smoker);
	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
