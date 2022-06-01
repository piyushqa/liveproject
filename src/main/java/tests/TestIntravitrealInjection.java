package tests;

import java.util.concurrent.TimeUnit;


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
import pages.PageIntravitrealInjection;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestIntravitrealInjection {

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



	// This test cases test the Intravitreal Injection

	@Parameters({ "Enviorment","FirstName", "LastName", "Provider", "InjectionName", "InjectionText", "SignedToday", "LidScrub1",
			"LidScrub2", "TropicalDrops1", "TropicalDrops2", "Drug", "StudyDrug", "PrivateVial", "SampleVial",
			"NewVialOpenForProcedure", "Diagonsis", "Limbus", "Needle", "Anethesia", "Injectiondrop", "InjectionIop",
			"TapIOP", "VAchecks", "FundsExam", "TapDone", "Surgon", "TimeFrame", "Drug1", "VisitType", "NoCharges",
			"Flag", "SC", "Category", "SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability",
			"significantProblem" })
	@Test(description = "This test cases test the Intravitreal Injection", priority = 2, enabled = true, dataProvider = "IntravitrealInjectionDetails", dataProviderClass = TestDataProviders.class)
	public void checkIntravitrealInjection(String enviorment,String fName, String lName, String provider, String injectionName,
			String InjectionText, String signedToday, String lidScrub1, String lidScrub2, String tropicalDrops1,
			String tropicalDrops2, String drug, String studtDrug, String privateVial, String sampleVial,
			String NewVialOpenForProcedure, String diagnosis, String limbus, String needle, String anethesia,
			String injectiondrop, String injectionIOP, String tapIOP, String VAchecks, String fundsExam, String tapDone,
			String surgon, String timeFrame, String drug1, String visitType, String noCharges, String flag, String sc,
			String category, String subCategory1, String subCategory2, String eye, String galuocmaSeverity,
			String galuocmaStability, String significantProblem) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(3000);

		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		Thread.sleep(2000);
		PageIntravitrealInjection injection = new PageIntravitrealInjection(driver, wait, builder);
		injection.checkIntravitrealInjection1(fName, lName, provider, injectionName, InjectionText,
				Boolean.parseBoolean(signedToday), lidScrub1, lidScrub2, tropicalDrops1, tropicalDrops2, drug,
				Boolean.parseBoolean(studtDrug), Boolean.parseBoolean(privateVial), Boolean.parseBoolean(sampleVial),
				Boolean.parseBoolean(NewVialOpenForProcedure), diagnosis, limbus, needle, anethesia, injectiondrop,
				injectionIOP, tapIOP, Boolean.parseBoolean(VAchecks), Boolean.parseBoolean(fundsExam),
				Boolean.parseBoolean(tapDone), surgon, timeFrame, drug1, visitType, Boolean.parseBoolean(noCharges),
				Boolean.parseBoolean(flag), sc, category, subCategory1, subCategory2, eye, galuocmaSeverity,
				galuocmaStability, Boolean.parseBoolean(significantProblem));
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}
