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
import pages.PagePosteriorSegment;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestPosteriorSegment {
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

	@Parameters({ "Enviorment", "FirstName", "LastName", "Category", "SubCategory1", "SubCategory2", "Eye",
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges", "Category",
			"Galucoma", "Location", "Modifier", "Severity", "VasselPathlogy", "vasselLocation", "VasselModifier",
			"VasselSeverity", "MaculaCategory", "MaculaDegeneration", "MaculaLocation", "MaculaModifier",
			"MaculaSeverity", "PeripheralCategory", "PeripheralOther", "PeripheralLocation", "PeripheralModifiers",
			"PeripheralSeverity", "VitreousPathology", "VitreousLocation", "VitreousModifier", "ViterousSeverity",
			"ViewPathology", "ViewModifier", "MedicineStatus" })
	@Test(description = "In this test cases we perform Posterior Segement", priority = 1, enabled = true, dataProvider = "PosteriorSegmentDetails", dataProviderClass = TestDataProviders.class)
	public void verifyPosteriorSegment(String enviorment, String firstName, String lastName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String Category, String Galucoma,
			String Location, String Modifier, String Severity, String vasselPathlogy, String vasselLocation,
			String vasselModifier, String vasselSeverity, String maculaCategory, String maculaDegeneration,
			String maculaLocation, String maculaModifier, String maculaSeverity, String peripheralCategory,
			String peripheralOther, String peripheralLocation, String peripheralModifiers, String peripheralSeverity,
			String vitreousPathology, String vitreousLocation, String vitreousModifier, String viterousSeverity,
			String viewPathology, String viewModifier, String medicineStatus) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PagePosteriorSegment(driver, wait, builder).verifyPosteriorSegment(firstName, lastName, category,
				subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges), Category,
				Galucoma, Location, Modifier, Severity, vasselPathlogy, vasselLocation, vasselModifier, vasselSeverity,
				maculaCategory, maculaDegeneration, maculaLocation, maculaModifier, maculaSeverity, peripheralCategory,
				peripheralOther, peripheralLocation, peripheralModifiers, peripheralSeverity, vitreousPathology,
				vitreousLocation, vitreousModifier, viterousSeverity, viewPathology, viewModifier,
				Boolean.parseBoolean(medicineStatus));
	}
}
