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
import pages.PageGonioscopyExam;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestGonioscopyExam {
	String exception = null;
	private WebDriverWait wait;
	private WebDriver driver;
	SetUp lstup = new SetUp();
	Actions builder;
	PgLanding lclPglanding;
	PgPatientSearch lclPgPatientSearch;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() {
		driver = lstup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	//In this test cases we add Gonioscopy Exam and match
	@Parameters({ "Enviorment","FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity",
			"GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "SelectExam", "AngleApproach",
			"Pigment", "IrisContourWidget", "StructuresWidget", "Abnormalities" })
	@Test(description = "In this test cases we add Gonioscopy Exam and match ", priority = 1, enabled = true, dataProvider = "GonioscopyExamDetails", dataProviderClass = TestDataProviders.class)
	public void checkForGonioscopyExam(String enviorment,String fName, String lName, String category, String subCategory1,
			String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String selectExam, String angleApproach,
			String pigment, String irisContourWidget, String structuresWidget, String abnormalities) throws Exception {

		//log in to application
		Thread.sleep(2000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		//search patient
		Thread.sleep(4000);
		boolean editPatient = false;
		lclPglanding = new PgLanding(driver);
		lclPgPatientSearch = lclPglanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		//call verfiry Gonioscopy Exam
		PageGonioscopyExam gonioscopyexam = new PageGonioscopyExam(driver, wait, builder);
		gonioscopyexam.verfiryGonioscopyExam(category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges),
				selectExam, angleApproach, pigment, irisContourWidget, structuresWidget, abnormalities);

	}

	@AfterTest
	public void logOut() {
		driver.close();
	}
}
