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
import pages.PageInactiveMedicalProblemAndVerifyStatusWithJson;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestInactiveMedicalProblemAndVerifyStatusWithJson {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	SetUp lsetUp = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSrch;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "MRN", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "Inactive", "Date","MedicineStatus"})
	@Test(description = "", priority = 1, enabled = true, dataProvider = "InactiveMedicalProblemDetails", dataProviderClass = TestDataProviders.class)
	public void checkInactiveMedicalProblemAndVerifyStatusWithJson(String enviorment, String mrn, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String inactive, String date,String medicineStatus)
			throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSrch = lclPgLanding.patientSearch();
		lclPgPatientSrch.searchPatient("", "", mrn, editPatient);

		new PageInactiveMedicalProblemAndVerifyStatusWithJson(driver, wait, builder)
				.verifyInactiveMedicalProblemAndVerifyStatusWithJson(mrn, category, subCategory1, subCategory2, eye,
						galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
						Boolean.parseBoolean(noCharges), Boolean.parseBoolean(inactive),date,Boolean.parseBoolean(medicineStatus));

	}

//	 @AfterTest
//	 public void logOut() {
//	 driver.close();
//	 }
}
