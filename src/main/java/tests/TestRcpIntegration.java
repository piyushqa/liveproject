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
import pages.PageRcpIntegration;
import pages.PgLanding;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class TestRcpIntegration {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	SetUp lsetUp = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSrch;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetUp.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().implicitlyWait(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		builder = new Actions(driver);
	}

	@Parameters({ "Enviorment", "PMSID", "MRN", "FirstName", "LastName", "Date", "SSN", "SexcualOrientation",
			"GenderIdentity", "Gender", "Address1", "Address2", "City", "State", "ZipCode", "HomePhone", "WorkPhone",
			"CellPhone", "Ethnicity", "Race", "Detailed race", "Email Address", "ContactMethod", "Category",
			"SubCategory1", "SubCategory2", "Eye", "GaluocmaSeverity", "GaluocmaStability", "significantProblem",
			"VisitType", "NoCharges", "Documents", "Name1", "Name2", "Name3", "Refferal", "Tranisition", "Comments" })

	@Test(description = "", priority = 1, enabled = true, dataProvider = "RcpInegrationDetails", dataProviderClass = TestDataProviders.class)
	public void checkRcpIntegration(String enviorment, String PMSID, String MRN, String firstName, String lastName,
			String Date, String ssn, String SexcualOrientation, String GenderIdentity, String gender, String Address1,
			String Address2, String City, String State, String ZipCode, String HomePhone, String WorkPhone,
			String cellPhone, String Ethnicity, String Race, String Detailedrace, String EmailAddress,
			String ContactMethod, String category, String subCategory1, String subCategory2, String eye,
			String galuocmaSeverity, String galuocmaStability, String significantProblem, String visitType,
			String noCharges, String documents, String name1, String name2, String name3, String refferal,
			String tranisition, String comments) throws Exception {

		LoginTest test = new LoginTest(driver);
		test.testLogin();

		new PageRcpIntegration(driver, wait, builder).verifyRcpIntegration(PMSID, MRN, firstName, lastName, Date, ssn,
				SexcualOrientation, GenderIdentity, gender, Address1, Address2, City, State, ZipCode, HomePhone,
				WorkPhone, cellPhone, Ethnicity, Race, Detailedrace, EmailAddress, ContactMethod, category,
				subCategory1, subCategory2, eye, galuocmaSeverity, galuocmaStability,
				Boolean.parseBoolean(significantProblem), visitType, Boolean.parseBoolean(noCharges), documents, name1,
				name2, name3, Boolean.parseBoolean(refferal), Boolean.parseBoolean(tranisition), comments);
	}
}
