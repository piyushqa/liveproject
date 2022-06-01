
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-83

//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-84

package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgMedicationOcular;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestMedicationOcular {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	public ScreenShot shot;
	Actions builder;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	// log on to pgMedicationOcular
	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "Eye History", "MedicationName", "options",
			"number", "medicine", "ByMonth", "day", "Other", "Supply", "Quantity", "month", "date", "year", "Password",
			"Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability",
			"significantProblem", "VisitType", "NoCharges" })
	@Test(description = "In this test caes we create medicine from dr first ,stop the medicine and match on other history", priority = 1, enabled = true, dataProvider = "medicationOcularDetails", dataProviderClass = TestDataProviders.class)
	public void checkCreateAndStopMedication(String enviorment, String fName, String lName, String provider,
			String eyeHistory, String medName, String options, String number, String medicine, String byMonth,
			String day, String other, String supply, String quantity, String month, String date, String year,
			String password, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, String significantProblem, String visitType,
			String noCharges) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		Thread.sleep(2000);
		PgMedicationOcular medOcu = new PgMedicationOcular(driver, wait, builder);
		medOcu.verfiyMedicationOcular(provider, eyeHistory, medName, options, number, medicine, byMonth, day, other,
				supply, quantity, date, month, year, password,category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem), visitType,
				Boolean.parseBoolean(noCharges));
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
