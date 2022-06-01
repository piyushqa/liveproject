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
import pages.PageClinicSiteForUserProfile;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestClinicSiteForUserProfile {
	String exception = null;
	public WebDriver driver;
	private WebDriverWait wait;
	SetUp lsetup = new SetUp();
	Actions builder;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "SelectAll", "FNameForOneUserProfile", "ClinicSite", "Role", "ProviderType",
			"AciUserRole", "SelectDegree", "MustHaveSupervisingDoctor", "FirstName", "MiddleName", "LastName",
			"Initials", "CanEditPracticeCPTCodes", "CanEditPracticeICDCodes", "CanEditPracticeSurgeryScreens",
			"HasPracticeAdministratorPermissions ", "MakeThisUserInvisible", "CanEditClinicalDecisionSupport",
			"CanEditPracticeContactLenses", "PracticeManagementId ", "PMSystemReferralCode", "DoctorNumber",
			"ProviderNPI", "ProviderTaxID", "ProviderERXUsername", "ProviderRXLicense", "PrimarySpecialty",
			"SecondarySpecialty", "ThirdSpecialty", "ClinicSitesAssociatedWithThisUser", "LoginName", "AssignPassword",
			"Email" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "ClinicSiteUserProfileDetails", dataProviderClass = TestDataProviders.class)
	public void checkClinicSiteForUserProfile(String enviorment, String selectAll, String fNameForOneUserProfile,
			String clinicSite, String role, String providerType, String aciUserRole, String selectDegree,
			String mustHaveSupervisingDoctor, String firstName, String middleName, String lastName, String initials,
			String canEditPracticeCPTCodes, String canEditPracticeICDCodes, String canEditPracticeSurgeryScreens,
			String hasPracticeAdministratorPermissions, String makeThisUserInvisible,
			String canEditClinicalDecisionSupport, String canEditPracticeContactLenses, String practiceManagementId,
			String pmSystemReferralCode, String doctorNumber, String providerNPI, String providerTaxID,
			String providerERXUsername, String providerRXLicense, String primarySpecialty, String secondarySpecialty,
			String thirdSpecialty, String clinicSitesAssociatedWithThisUser, String loginName, String assignPassword,
			String email) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageClinicSiteForUserProfile(wait, driver, builder).verifyClinicSiteForUserProfile(
				Boolean.parseBoolean(selectAll), fNameForOneUserProfile, clinicSite, role, providerType, aciUserRole,
				selectDegree, mustHaveSupervisingDoctor, firstName, middleName, lastName, initials,
				Boolean.parseBoolean(canEditPracticeCPTCodes), Boolean.parseBoolean(canEditPracticeICDCodes),
				Boolean.parseBoolean(canEditPracticeSurgeryScreens),
				Boolean.parseBoolean(hasPracticeAdministratorPermissions), Boolean.parseBoolean(makeThisUserInvisible),
				Boolean.parseBoolean(canEditClinicalDecisionSupport),
				Boolean.parseBoolean(canEditPracticeContactLenses), practiceManagementId, pmSystemReferralCode,
				doctorNumber, providerNPI, providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty,
				secondarySpecialty, thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName, assignPassword,
				email);

	}

//	@AfterTest
//	public void logOut() {
//		driver.close();
//	}
}
