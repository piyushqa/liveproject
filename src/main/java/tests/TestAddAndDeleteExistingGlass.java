//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-177
//http://128.136.92.176/testlink/linkto.php?tprojectPrefix=INTE&item=testcase&id=INTE-180

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
import pages.PageAddAndDeleteExistingGlass;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestAddAndDeleteExistingGlass {
	String exception = null;
	public WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PageAddAndDeleteExistingGlass addAndDelEG = null;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	// @Test(groups= {"logInAlways"})
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
		// ExtentReports report=new ExtentReports("./test-output/");

	}

	// This test cases is add the Existing glass and delete the existing glass
	@Parameters({ "Enviorment", "FirstName", "LastName", "Provider", "OD", "OdSphere", "OdCyliender", "OdAxis", "OdAdd",
			"OS", "OsSphere", "OsCyliender", "OsAxis", "OsAdd", "Prism", "Prism1", "Prism2", "Prism3", "OdDistance",
			"OsDistance", "OdIntermediate", "OsIntermediate", "OdNear", "OsNear", "OdComment", "OsComment", "VisitType",
			"NoCharges" })
	@Test(description = "This test cases is add the Existing glass and delete the existing glass", priority = 2, dataProvider = "AddAndDeleteExistingGlassDetails", dataProviderClass = TestDataProviders.class)
	public void checkAddAndDeleteExistingGlass(String enviorment, String fName, String lName, String provider,
			String od, String odSphere, String odCyliender, String odAxis, String odAdd, String os, String osSphere,
			String osCyliender, String osAxis, String osAdd, String prism, String prism1, String prism2, String prism3,
			String odDistance, String osDistance, String odIntermediate, String osIntermediate, String odNear,
			String osNear, String OdComment, String osComment, String visitType, String noCharges) throws Exception {
		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Thread.sleep(4000);
		boolean editPatient = false;
		lclPgLanding = new PgLanding(driver);
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
		Thread.sleep(5000);
		addAndDelEG = new PageAddAndDeleteExistingGlass(wait, driver, builder);
		addAndDelEG.verifyAddAndDeleteExistingGlass(provider, od, odSphere, odCyliender, odAxis, odAdd, os, osSphere,
				osCyliender, osAxis, osAdd, prism, prism1, prism2, prism3, odDistance, osDistance, odIntermediate,
				osIntermediate, odNear, osNear, OdComment, osComment, visitType, Boolean.parseBoolean(noCharges));

		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

	// @AfterTest
	// public void logout() {
	// driver.close();
	// }
}
