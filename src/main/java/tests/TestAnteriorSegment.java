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
import pages.PageAnteriorSegment;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAnteriorSegment {

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
			"GaluocmaSeverity", "GaluocmaStability", "significantProblem", "VisitType", "NoCharges",
			"ConjunctiveCategory", "ConjunctiveOther", "ConjunctiveLocation", "ConjunctiveModifier",
			"ConjunctiveSeverity", "CorneaCategory", "CorneaOther", "CorneaLocation", "CorneaModifier",
			"CorneaSeverity", "AnteriorOther", "AnteriorLocation", "AnteriorModifier", "AnteriorSeverity", "IrisOther",
			"IrisLocation", "IrisModifier", "IrisSeverity", "LensCategory", "LensOther", "LensLocation", "LensModifier",
			"LensSeverity" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "AnteriorSegmentDetails", dataProviderClass = TestDataProviders.class)
	public void verifyAnteriorSegment(String enviorment, String firstName, String lastName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String ConjunctiveCategory,
			String ConjunctiveOther, String ConjunctiveLocation, String ConjunctiveModifier, String ConjunctiveSeverity,
			String CorneaCategory, String CorneaOther, String CorneaLocation, String CorneaModifier,
			String CorneaSeverity, String anteriorOther, String anteriorLocation, String anteriorModifier,
			String anteriorSeverity, String irisOther, String irisLocation, String irisModifier, String irisSeverity,
			String lensCategory, String lensOther, String lensLocation, String lensModifier, String lensSeverity)
			throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageAnteriorSegment(driver, wait, builder).checkAnteriorSegment(firstName, lastName, category, subCategory1,
				subCategory2, eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem),
				visitType, Boolean.parseBoolean(noCharges), ConjunctiveCategory, ConjunctiveOther, ConjunctiveLocation,
				ConjunctiveModifier, ConjunctiveSeverity, CorneaCategory, CorneaOther, CorneaLocation, CorneaModifier,
				CorneaSeverity, anteriorOther, anteriorLocation, anteriorModifier, anteriorSeverity, irisOther,
				irisLocation, irisModifier, irisSeverity, lensCategory, lensOther, lensLocation, lensModifier,
				lensSeverity);
	}
}
