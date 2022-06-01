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
import pages.PageInterMagicRule;
import pages.PgLanding;
import utilities.ScreenShot;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestInterMagicRule {
	SetUp lsetUp = new SetUp();
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	PgLanding lclPglanding;
	ExtentReports extent;
	ExtentTest test;
	ScreenShot shot;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(config.ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);

	}

	@Parameters({ "ENVIORMENT", "Role", "ProviderType", "AciUserRole", "SelectDegree", "MustHaveSupervisingDoctor",
			"FirstName", "MiddleName", "LastName", "Initials", "CanEditPracticeCPTCodes", "CanEditPracticeICDCodes",
			"CanEditPracticeSurgeryScreens", "HasPracticeAdministratorPermissions ", "MakeThisUserInvisible",
			"CanEditClinicalDecisionSupport", "CanEditPracticeContactLenses", "PracticeManagementId ",
			"PMSystemReferralCode", "DoctorNumber", "ProviderNPI", "ProviderTaxID", "ProviderERXUsername",
			"ProviderRXLicense", "PrimarySpecialty", "SecondarySpecialty", "ThirdSpecialty",
			"ClinicSitesAssociatedWithThisUser", "LoginName", "AssignPassword", "Email", "InterMagicRule",
			"SelectTriggerType", "Category1", "Category2", "Category3", "ICD", "Eye", "GlaucomaSeverity",
			"GlaucomaStability", "SelectActonType1", "SpecifyProvider", "SpecifyTimeframe", "Comments", "TrigeerType",
			"TriggerAction", "InterMagicRuleName", "SelectActonType2", "Plan Liberary", "Retina", "SelectActonType3",
			"RadioLogyTest", "OtherTest", "SelectActonType4", "SelectLabTest", "SelectActionType5", "EyeTestCategory",
			"EyeTest" })
	@Test(description = "", priority = 1, enabled = true, dataProvider = "UserMgtIntermagicRuleDetails", dataProviderClass = TestDataProviders.class)
	public void checkInterMagicRule(String Enviorment, String role, String providerType, String aciUserRole,
			String selectDegree, String mustHaveSupervisingDoctor, String firstName, String middleName, String lastName,
			String initials, String canEditPracticeCPTCodes, String canEditPracticeICDCodes,
			String canEditPracticeSurgeryScreens, String hasPracticeAdministratorPermissions,
			String makeThisUserInvisible, String canEditClinicalDecisionSupport, String canEditPracticeContactLenses,
			String practiceManagementId, String pmSystemReferralCode, String doctorNumber, String providerNPI,
			String providerTaxID, String providerERXUsername, String providerRXLicense, String primarySpecialty,
			String secondarySpecialty, String thirdSpecialty, String clinicSitesAssociatedWithThisUser,
			String loginName, String assignPassword, String email, String interMagicRule, String SelectTriggerType,
			String Category1, String Category2, String Category3, String ICD, String Eye, String GlaucomaSeverity,
			String GlaucomaStability, String SelectActonType1, String SpecifyProvider, String SpecifyTimeframe,
			String Comments, String TrigeerType, String TriggerAction, String InterMagicRuleName,
			String SelectActonType2, String planLiberary, String retina, String SelectActonType3, String radiologyTest,
			String otherTest, String SelectActonType4, String selectLabTest, String SelectActonType5,
			String eyeTestCategory, String eyeTest) throws Exception {
		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageInterMagicRule(driver, wait, builder).verifyInterMagicRule(role, providerType, aciUserRole,
				selectDegree, mustHaveSupervisingDoctor, firstName, middleName, lastName, initials,
				Boolean.parseBoolean(canEditPracticeCPTCodes), Boolean.parseBoolean(canEditPracticeICDCodes),
				Boolean.parseBoolean(canEditPracticeSurgeryScreens),
				Boolean.parseBoolean(hasPracticeAdministratorPermissions), Boolean.parseBoolean(makeThisUserInvisible),
				Boolean.parseBoolean(canEditClinicalDecisionSupport),
				Boolean.parseBoolean(canEditPracticeContactLenses), practiceManagementId, pmSystemReferralCode,
				doctorNumber, providerNPI, providerTaxID, providerERXUsername, providerRXLicense, primarySpecialty,
				secondarySpecialty, thirdSpecialty, clinicSitesAssociatedWithThisUser, loginName, assignPassword, email,
				Boolean.parseBoolean(interMagicRule), SelectTriggerType, Category1, Category2, Category3, ICD, Eye,
				GlaucomaSeverity, GlaucomaStability, SelectActonType1, SpecifyProvider, SpecifyTimeframe, Comments,
				TrigeerType, TriggerAction, InterMagicRuleName, SelectActonType2, planLiberary, retina,
				SelectActonType3, radiologyTest, otherTest, SelectActonType4, selectLabTest, SelectActonType5,
				eyeTestCategory, eyeTest);

	}

}
