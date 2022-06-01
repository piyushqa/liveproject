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
import pages.PageImportCCDA;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestImportrCCDA {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientsrch;
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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "DocumentCategory", "FileName", "Allergies",
			"Recation", "Severity", "Date", "MedicationName" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "ImportCCDADetails", dataProviderClass = TestDataProviders.class)
	public void checkImportCCDA(String enviorment, String fName, String lName, String provider, String documentCategory,
			String fileName, String allergies, String recation, String severity, String Date, String medicationName)
			throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientsrch = lclPgLanding.patientSearch();
		lclPgPatientsrch.searchPatient(fName, lName, "", editPatient);

		new PageImportCCDA(driver, wait, builder).verifyImportCCDA(provider, documentCategory, fileName, allergies,
				recation, severity, Date, medicationName);

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
