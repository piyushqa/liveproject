
package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageInterpretationOfOpthalmoscopy;
import pages.PgLanding;
import pages.PgPatientSearch;

import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestInterpretationOfOpthalmoscopy {

	SetUp lsetUp = new SetUp();
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPglanding;
	PgPatientSearch srchPgPatient;
	ExtentReports extent;
	ExtentTest test;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);

	}

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "SelectDiagonisticTest", "FileName",
			"Abnormalities", "Impression", "severity", "Progression", "reliability", "SavedDocuments", "Diagnosis" })
	@Test(description = "In this test cases we upload the file and perfrom Intergiview operation", priority = 1, enabled = true, dataProvider = "InterpretationOpthalmoscopyDetails", dataProviderClass = TestDataProviders.class)
	public void checkInterpretationOfOpthalmoscopy(String enviorment, String fName, String lName, String provider,
			String selectDiaDiagonisticTest, String FileName, String abnormalities, String impression, String severity,
			String progression, String reliability, String savedDocuments, String diagnosis) throws Exception {

		// LogIn to apllication
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		// search patient
		Thread.sleep(4000);
		boolean editPatient = false;
		lclPglanding = new PgLanding(driver);
		srchPgPatient = lclPglanding.patientSearch();
		srchPgPatient.searchPatient(fName, lName, "", editPatient);

		// invoke method
		new PageInterpretationOfOpthalmoscopy(driver, wait, builder).verifyInterpretationOpthalmoscopy(provider,
				selectDiaDiagonisticTest, FileName, abnormalities, impression, severity, progression, reliability,
				savedDocuments, diagnosis);
	}

//	@AfterMethod
//	public void logOut(ITestResult result) {
//		//driver.close();
//		if(result.getStatus()==ITestResult.FAILURE) {
//			JiraIntegration jira=new JiraIntegration();
//			jira.jiraSendRequest();
//		}
//	}
}
