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
import com.relevantcodes.extentreports.ExtentTest;
import config.ProjectSettings;
import pages.PageLogIn;
import pages.PgLanding;
import pages.PgUserManagement;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestUserManagement {
	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	public static ExtentTest test;
	private WebDriverWait wait;
	private Actions builder;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		builder = new Actions(driver);
	}



	@Parameters({"ENVIORMENT","Role", "ProviderType", "AciUserRole", "SelectDegree", "MustHaveSupervisingDoctor", "FirstName",
			"MiddleName", "LastName", "Initials", "CanEditPracticeCPTCodes", "CanEditPracticeICDCodes",
			"CanEditPracticeSurgeryScreens", "HasPracticeAdministratorPermissions ", "MakeThisUserInvisible",
			"CanEditClinicalDecisionSupport", "CanEditPracticeContactLenses", "PracticeManagementId ",
			"PMSystemReferralCode", "DoctorNumber", "ProviderNPI", "ProviderTaxID", "ProviderERXUsername",
			"ProviderRXLicense", "PrimarySpecialty", "SecondarySpecialty", "ThirdSpecialty",
			"ClinicSitesAssociatedWithThisUser", "LoginName", "AssignPassword", "Email" })

	@Test(priority = 2, dataProvider = "userManagmentDetails", dataProviderClass = TestDataProviders.class)
	public void CheckProviderCreate(String Enviorment,String role, String providerType, String aciUserRole, String selectDegree,
			String mustHaveSupervisingDoctor, String firstName, String middleName, String lastName, String initials,
			String canEditPracticeCPTCodes, String canEditPracticeICDCodes, String canEditPracticeSurgeryScreens,
			String hasPracticeAdministratorPermissions, String makeThisUserInvisible,
			String canEditClinicalDecisionSupport, String canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email) throws Exception {

		Thread.sleep(1000);
		LoginTest test = new LoginTest(driver);
		test.testLogin();
		Thread.sleep(3000);
		PgUserManagement userManagment = new PgUserManagement(driver, wait, builder);
		// call createUser

		userManagment.createProvider(role, providerType, aciUserRole, selectDegree, mustHaveSupervisingDoctor,
				firstName, middleName, lastName, initials, Boolean.parseBoolean(canEditPracticeCPTCodes),
				Boolean.parseBoolean(canEditPracticeICDCodes), Boolean.parseBoolean(canEditPracticeSurgeryScreens),
				Boolean.parseBoolean(hasPracticeAdministratorPermissions), Boolean.parseBoolean(makeThisUserInvisible),
				Boolean.parseBoolean(canEditClinicalDecisionSupport),
				Boolean.parseBoolean(canEditPracticeContactLenses), practiceManagementId, pmSystemReferralCode,
				doctorNumber, providerNPI, providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty,
				secondarySpecialty, thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName, assignPassword,
				email);

		Thread.sleep(2000);
		shot = new ScreenShot();
		ScreenShot.screen(driver);
	}

//	@AfterTest
//	public void logout() {
//		driver.close();
//	}
}
