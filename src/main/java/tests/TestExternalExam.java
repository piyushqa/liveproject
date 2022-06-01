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
import pages.PageExternalExam;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestExternalExam {

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
			"ConfonationLocation", "ConfonationSeverity", "OrbitPathlogy", "OrbitLocation", "OrbitModifier",
			"OrbitSeverity", "OcularCategory", "OcularGlaucoma", "OcularLocation", "OcularModifier", "OcularSeverity",
			"PupilLight", "PupilShape", "PupilReactivity", "PupilRAPD" })

	@Test(description = "", priority = 1, enabled = true, dataProvider = "ExternalExamDetails", dataProviderClass = TestDataProviders.class)
	public void verifyExternalExam(String enviorment, String firstName, String lastName, String category,
			String subCategory1, String subCategory2, String eye, String galuocmaSeverity, String galuocmaStability,
			String significantProblem, String visitType, String noCharges, String confonationLocation,
			String confonationSeverity, String orbitPathlogy, String orbitLocation, String orbitModifier,
			String orbitSeverity, String ocularCategory, String ocularGlaucoma, String ocularLocation,
			String ocularModifier, String ocularSeverity, String pupilLight, String pupilShape, String pupilReactivity,
			String pupilRAPD) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageExternalExam(driver, wait, builder).checkExternalExam(firstName, lastName, category, subCategory1,
				subCategory2, eye, galuocmaSeverity, galuocmaStability, Boolean.parseBoolean(significantProblem),
				visitType, Boolean.parseBoolean(noCharges), confonationLocation, confonationSeverity, orbitPathlogy,
				orbitLocation, orbitModifier, orbitSeverity, ocularCategory, ocularGlaucoma, ocularLocation,
				ocularModifier, ocularSeverity, pupilLight, pupilShape, pupilReactivity, pupilRAPD);

	}

}
