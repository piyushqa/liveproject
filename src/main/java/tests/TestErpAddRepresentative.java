//package tests;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//
//import config.ProjectSettings;
//import pages.PgCreatePatient;
//import pages.PgErpAddRepresentative;
//import pages.PgErpEducationResources;
//import pages.PgErpLanding;
//import pages.PgErpPortalLogin;
//import pages.PgLanding;
//import pages.PgLogin;
//import pages.PgMedicationOcular;
//import pages.PgPatientSearch;
//import pages.pgErpPatientModification;
//import utilities.ScreenShot;
//import utilities.SetUp;
//import utilities.TestDataProviders;
//
//public class TestErpAddRepresentative {
//	String exception = null;
//	public WebDriver driver;
//	SetUp lsetup = new SetUp();
//	PgLanding lclPgLanding;
//
//	PgPatientSearch lclPgPatientSearch;
//	PgCreatePatient lclpgCreatePatient;
//	PgErpLanding lclPgLanding1;
//	public static ExtentReports extent;
//	public static ExtentTest test;
//	private WebDriverWait wait;
//	private Actions action;
//	public ScreenShot shot;
//
//	@BeforeTest
//	// @Test(groups= {"logInAlways"})
//	public void beforeTest() throws Exception {
//		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
//		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
//
//	// logOn to certification Site
//	// @Parameters({ "baseURL", "username", "password" })
//	// @Test(description = "This test logs into the application", priority = 1,
//	// enabled = true, dataProvider = "LoginCredentials", dataProviderClass =
//	// TestDataProviders.class)
//	// public void testLogin(String baseURL, String usrnm, String pwd) throws
//	// Exception {
//	// boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
//	// Reporter.log(ProjectSettings.baseURL + " opened successfully.");
//	// PgLogin pgLogin = new PgLogin(driver);
//	// try {
//	// if (pgOpenStatus) {
//	// lclPgLanding = pgLogin.validLogin(usrnm, pwd);
//	// Reporter.log("Logged Successfully!");
//	// }
//	// } catch (Exception ex) {
//	// Reporter.log(ex.toString());
//	// }
//	// }
//
//	@Parameters({"Enviorment","FirstName", "LastName", "Account", "Name", "PhoneNumber", "Email", "Username", "PatientRelation",
//			"LogUserName", "LogPassword", "Month", "date", "Year", "ZIPCODE", "NEWUSERNAME", "NewPswd",
//			"ConfirmNewPswd" })
//
//	@Test(description = "This test add representative", priority = 2, enabled = true, dataProvider = "ErpAddReprestantiveDetails", dataProviderClass = TestDataProviders.class)
//	public void checkAddRepresentative(String enviorment,String fName, String lName, String account, String name, String phoneNumber,
//			String email, String userName, String patientRelation, String logusername, String pswd,
//			String calenderMonth, String calenderDate, String calenderYear, String Zipcode, String newUserName,
//			String newPswd, String ConfirmNewPswd) throws Exception {
//		Thread.sleep(1000);
//		LoginTest test = new LoginTest(driver);
//		test.testLogin();
//
//		Thread.sleep(5000);
//		boolean editPatient = false;
//		lclPgLanding = new PgLanding(driver);
//		lclPgPatientSearch = lclPgLanding.patientSearch();
//		lclPgPatientSearch.searchPatient(fName, lName, "", editPatient);
//
//		Thread.sleep(3000);
//		addReprestative.verifyAddReprestantive(account, name, phoneNumber, email, userName, patientRelation,
//				logusername, pswd, calenderMonth, calenderDate, calenderYear, Zipcode, newUserName, newPswd,
//				ConfirmNewPswd, fName, lName);
//		Thread.sleep(2000);
//		shot = new ScreenShot();
//		ScreenShot.screen(driver);
//	}
//	@AfterTest
//	 public void logout() {
//	 driver.close();
//	 }
//
//}
