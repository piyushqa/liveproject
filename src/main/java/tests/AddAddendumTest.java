package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import config.ProjectSettings;
import pages.PageLogIn;
import pages.PgCreatePatient;
import pages.PgLanding;
import pages.PgLogin;
import pages.PgPatientSearch;
import utilities.SetUp;
import utilities.TestDataProviders;

public class AddAddendumTest {

	String exception = null;
	public WebDriver driver;
	SetUp lsetup = new SetUp();
	PgLanding lclPgLanding;
	PgPatientSearch lclPgPatientSearch;
	PgCreatePatient lclpgCreatePatient;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;
	Actions action;

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = lsetup.instBrowser(ProjectSettings.browserType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(ProjectSettings.pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ProjectSettings.elementWaitTimeOut);
		action = new Actions(driver);
	}

	@Parameters({ "baseURL", "username", "password" })
	@Test(description = "This test logs into the application", priority = 1, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = TestDataProviders.class)
	public void tstLogin(String baseURL, String usrnm, String pwd) throws Exception {
		boolean pgOpenStatus = lsetup.getPage(driver, baseURL);
		Reporter.log(ProjectSettings.baseURL + " opened successfully.");
		PageLogIn pgLogin = new PageLogIn(driver);
		try {
			if (pgOpenStatus) {
				lclPgLanding = pgLogin.validLogin1(usrnm, pwd);
				Reporter.log("Logged Successfully!");
			}
		} catch (Exception ex) {
			Reporter.log(ex.toString());
		}
	}

	@Parameters({ "FirstName", "LastName" })
	@Test(description = "Test to search for patient on Patient Search page", priority = 2, enabled = true, dataProvider = "getDetailsForPatientSearch", dataProviderClass = TestDataProviders.class)
	public void tstSearchPatient(String searchPatientFName, String searchPatientLName) throws Exception {
		boolean editPatient = false;
		lclPgPatientSearch = lclPgLanding.patientSearch();
		lclPgPatientSearch.searchPatient(searchPatientFName, searchPatientLName, "", editPatient);
	}

	@Parameters({ "EncounterDate", "AddendumValue", "AddendummStatus" })
	@Test(description = "Test to add addendum", priority = 3, enabled = true, dataProvider = "addendum", dataProviderClass = TestDataProviders.class)
	public void addAddendum(String encounterDate, String addendum, String status) throws Exception {
		By priorEncounterContainerTable = By.cssSelector("#gwt-debug-priorClinicVisits-container > table > tbody");
		ensureElementToBeClickable(priorEncounterContainerTable);
		WebElement priorEncounterContainerTableElement = driver.findElement(priorEncounterContainerTable);
		priorEncounterContainerTableElement.click();
		List<WebElement> tableRows = priorEncounterContainerTableElement.findElements(By.xpath(".//*"));
		if (tableRows.isEmpty())
			throw new NoSuchElementException("No Encounter exists");

		for (int i = 0; i < tableRows.size(); i++) {
			WebElement date = driver
					.findElement(By.cssSelector("#priorClinicVisits-item-" + i + " > td:nth-child(1) > span"));
			String existingValue = date.getText();
			if (existingValue.equals(encounterDate)) {
				WebElement addLink = driver
						.findElement(By.cssSelector("#priorClinicVisits-item-" + i + " > td:nth-child(5) > span"));
				ensureElementToBeClickable(addLink);
				addLink.click();
				addAddendum(addendum, status);

				By doneAddendum = By.cssSelector("#gwt-debug-addendum-done > a");
				ensureElementToBeClickable(doneAddendum);
				driver.findElements(doneAddendum).get(0).click();
				break;
			}
		}
	}

	private void addAddendum(String addendum, String status) throws InterruptedException {
		By addNew = By.cssSelector("#gwt-debug-addendum-addNew");
		ensureElementToBeClickable(addNew);
		driver.findElement(addNew).click();

		By textArea = By.cssSelector("#gwt-debug-addendum-textEntry");
		ensureElementToBeClickable(textArea);
		driver.findElement(textArea).sendKeys(addendum);

		By addendumStatusContainer = By.cssSelector("#gwt-debug-addendum-status-container");
		ensureElementToBeClickable(addendumStatusContainer);

		By statusRadio = null;
		By visibleAddendum = null;

		switch (status) {
		case "Approved":
			statusRadio = By.cssSelector("#addendum-status-item-0");
			visibleAddendum = By.cssSelector("#gwt-debug-addendum-approved-0-text");
			break;
		case "Rejected":
			statusRadio = By.cssSelector("#addendum-status-item-1");
			visibleAddendum = By.cssSelector("#gwt-debug-addendum-rejected-0-text");
			break;
		case "Pending":
			statusRadio = By.cssSelector("#addendum-status-item-2");
			visibleAddendum = By.cssSelector("#gwt-debug-addendum-pending-0-text");
			break;
		default:
			break;
		}
		if (statusRadio != null) {
			ensureElementToBeClickable(statusRadio);
			driver.findElement(statusRadio).click();
		}

		By done = By.cssSelector("#gwt-debug-addendum-done > a");
		ensureElementToBeClickable(done);
		driver.findElements(done).get(1).click();

		Thread.sleep(2 * 1000);
		ensureElementToBeClickable(visibleAddendum);
		String actual = driver.findElement(visibleAddendum).getText();
		assertEquals(actual, addendum);
	}

	private void ensureElementToBeClickable(By element) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void ensureElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@AfterTest
	void closeDriver() {
		driver.quit();
	}

}
