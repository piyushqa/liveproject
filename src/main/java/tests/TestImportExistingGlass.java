

//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-179



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
import pages.PageImportExistingGlass;
import pages.PgCreatePatient;
import pages.PgErpLanding;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestImportExistingGlass {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	public ScreenShot shot;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	PgErpLanding lclPgLanding1;
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// logOn to certification Site
	// @Parameters({ "baseURL", "username", "password" })
	// @Test(description = "This test logs into the application", priority = 1,
	// enabled = true, dataProvider = "LoginCredentials", dataProviderClass =
	// TestDataProviders.class)
	// public void testLogin(String baseURL, String usrnm, String pwd) throws
	// Exception {
	// boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
	// Reporter.log(ProjectSettings.baseURL + " opened successfully.");
	// PgLogin pgLogin = new PgLogin(driver);
	// try {
	// if (pgOpenStatus) {
	// lclPgLanding = pgLogin.validLogin(usrnm, pwd);
	// Reporter.log("Logged Successfully!");
	// }
	// } catch (Exception ex) {
	// Reporter.log(ex.toString());
	// }
	// }

	// This test perform encounter on Existin glass and import
	@Parameters({"Enviorment","FirstName", "LastName", "provider", "Category", "subCategory", "subCategory1", "Eye",
			"Glaucoma Severity", "Glaucoma Stability", "DominantEye", "Distance", "Near", "OD", "OdSphere",
			"OdCyliender", "OdAxis", "OdAdd", "OS", "OsSphere", "OsCyliender", "OsAxis", "OsAdd", "Prism", "Prism1",
			"Prism2", "Prism3", "OdDistance", "OsDistance", "OdIntermediate", "OsIntermediate", "OdNear", "OsNear",
			"OdComment", "OsComment", "VisitType", "Nocharges", "Import" })
	@Test(description = "This test perform encounter on Existin glass and import", priority = 2, enabled = true, dataProvider = "ImportExistingGlassDetails", dataProviderClass = TestDataProviders.class)
	public void checkImportExistingGlass(String enviorment,String fName, String lName, String provider, String category,
			String subCategory, String subCategory1, String eye, String glaucomaSeverity, String glaucomaStability,
			String dominantEye, String distance, String near, String od, String odSphere, String odCyliender,
			String odAxis, String odAdd, String os, String osSphere, String osCyliender, String osAxis, String osAdd,
			String prism, String prism1, String prism2, String prism3, String odDistance, String osDistance,
			String odIntermediate, String osIntermediate, String odNear, String osNear, String OdComment,
			String osComment, String visitType, String noCharges, String import1) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		Thread.sleep(5000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);

		PageImportExistingGlass importEncounter = new PageImportExistingGlass(driver, wait, builder);
		importEncounter.importExistingGlass(provider, category, subCategory, subCategory1, eye, glaucomaSeverity,
				glaucomaStability, dominantEye, distance, near, od, odSphere, odCyliender, odAxis, odAdd, os, osSphere,
				osCyliender, osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate,
				osIntermediate, odNear, osNear, OdComment, osComment, visitType, Boolean.parseBoolean(noCharges),
				import1, fName, lName);
		Thread.sleep(2000);
		ScreenShot scr = new ScreenShot();
		ScreenShot.screen(driver);

	}

	// // close the driver
//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
